package com.shop.interceptor;

import com.shop.exception.CustomizeException;
import com.shop.util.ResultCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ClientLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user")==null) {

            throw new CustomizeException(ResultCode.USER_NOT_LOGGED_IN);
        }

        return true;
    }
}
