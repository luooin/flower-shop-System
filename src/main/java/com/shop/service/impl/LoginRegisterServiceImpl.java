package com.shop.service.impl;

import com.shop.controller.dao.UserMapper;
import com.shop.exception.CustomizeException;
import com.shop.service.impl.pojo.Admin;
import com.shop.service.impl.pojo.User;
import com.shop.service.LoginRegisterService;
import com.shop.util.ResultCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Resource
    private UserMapper userMapper;


    @Override
    public void userLogin(User record, HttpSession session) {
        User user=userMapper.selectByUserName(record.getUserName());
        if(user==null){

            throw new CustomizeException(ResultCode.USER_NOT_FOUND);
        }
        if(!user.getPassword().equals(record.getPassword())){

            throw new CustomizeException(ResultCode.PASSWORD_ERROR);
        }
        session.setAttribute("user",user);
    }


    @Override
    public void userRegister(User record) {
        String userName = record.getUserName();
        User user=userMapper.selectByUserName(record.getUserName());
        if(user!=null){
            throw new CustomizeException(ResultCode.FAILED,"用户名已存在");
        }
        userMapper.insert(record);
    }

    @Override
    public void adminLogin(Admin admin, HttpSession session) {

    }
}
