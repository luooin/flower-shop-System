package com.shop.controller;

import com.shop.exception.CustomizeException;
import com.shop.service.impl.pojo.Admin;
import com.shop.service.impl.pojo.User;
import com.shop.service.LoginRegisterService;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
public class LoginRegisterController {

    @Autowired
    private LoginRegisterService loginRegisterService;


    @PostMapping("/user/login")
    @ResponseBody
    public ResultVO userLoginHandler(@RequestBody @Valid User user, HttpSession session) {
        loginRegisterService.userLogin(user,session);
        return new ResultVO(ResultCode.SUCCESS,"/");
    }


    @PostMapping("/user/register")
    @ResponseBody
    public ResultVO userRegisterHandler(@RequestBody @Valid User user) {
        loginRegisterService.userRegister(user);
        return new ResultVO(ResultCode.SUCCESS,"/login");
    }


    @PostMapping("/admin/login")
    @ResponseBody
    public ResultVO adminLoginHandler(@RequestBody Admin admin, HttpSession session) {
        if(!("admin".equals(admin.getAdminName())&& "123456".equals(admin.getPassword()))){
            throw new CustomizeException(ResultCode.FAILED,"管理员账户或密码错误");
        }
        session.setAttribute("admin",admin);
        return new ResultVO(ResultCode.SUCCESS,"/admin/game_manage");
    }


    @GetMapping("/logout")
    public String userLogout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }


    @GetMapping("/admin/logout")
    public String adminLogout(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/";
    }

    @GetMapping("/checkLoggedIn")
    @ResponseBody
    public ResultVO checkUserIsLoggedIn(HttpSession session) {
        if (session.getAttribute("user") == null) {
            throw new CustomizeException(ResultCode.USER_NOT_LOGGED_IN);
        }
        return new ResultVO(ResultCode.SUCCESS);
    }
}
