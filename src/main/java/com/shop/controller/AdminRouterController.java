package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminRouterController {


    @GetMapping("/user_manage")
    public String toUserManage(){
        return "admin/user";
    }


    @GetMapping({"/","/game_manage"})
    public String toGameManage(){
        return "admin/games";
    }

    @GetMapping({"/","/kucun"})
    public String kucun(){
        return "admin/kucun";
    }
    @GetMapping("/category_manage")
    public String toCategoryManage(){
        return "admin/category";
    }


    @GetMapping("/order_manage")
    public String toOrderManage(){
        return "admin/order";
    }

    @GetMapping("/add_game")
    public String AddGame(){
        return "admin/add_game";
    }


    @GetMapping("/login")
    public String toAdminLogin(){
        return "admin/login";
    }

}
