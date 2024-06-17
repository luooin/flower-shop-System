package com.shop.controller;

import com.shop.service.impl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@Controller
public class ClientRouterController {


    @GetMapping({"/","/index"})
    public String toHomePage(){
        return "index";
    }


    @GetMapping("/login")
    public String toLogin(HttpSession session){
        if(session.getAttribute("user")!=null){
            return "redirect:/";
        }
        return "login";
    }


    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }


    @GetMapping("/{userName}/orders")
    public String toOrderCenter(@PathVariable("userName") String userName,HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null && user.getUserName().equals(userName)){
            return "user_orders";
        }
        return "redirect:/login";
    }


    @GetMapping("/{userName}/shopping_cart")
    public String toUserShoppingCart(@PathVariable("userName") String userName,HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null && user.getUserName().equals(userName)){
            return "shopping_cart";
        }
        return "redirect:/login";
    }


}
