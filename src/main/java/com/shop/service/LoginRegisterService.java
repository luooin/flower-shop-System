package com.shop.service;

import com.shop.service.impl.pojo.Admin;
import com.shop.service.impl.pojo.User;

import javax.servlet.http.HttpSession;


public interface LoginRegisterService {


    void userLogin(User record, HttpSession session);


    void userRegister(User record);


    void adminLogin(Admin admin, HttpSession session);
}
