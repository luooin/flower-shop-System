package com.shop.exception;

import com.shop.util.ResultCode;
import com.shop.util.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomizeException.class)
    public ResultVO customizeExceptionHandler(CustomizeException e){
        log.error(e.getMessage());
        return new ResultVO(e.getCode(),e.getMsg(),null);
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public ResultVO methodArgumentNotValidExceptionHandler(Exception e) {
        BindingResult bindingResult;
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException ex= (MethodArgumentNotValidException)e;
            bindingResult = ex.getBindingResult();
        }else {
            BindException ex=(BindException)e;
            bindingResult = ex.getBindingResult();
        }
        ObjectError error = bindingResult.getAllErrors().get(0);
        return new ResultVO(ResultCode.ARGUMENT_NOT_VALID,error.getDefaultMessage(),null);
    }



    @ExceptionHandler(Exception.class)
    public ResultVO ExceptionHandler(Exception e){
        log.error(e.getMessage());
        return new ResultVO(ResultCode.UNKNOWN_ERROR,e.getMessage());
    }
}
