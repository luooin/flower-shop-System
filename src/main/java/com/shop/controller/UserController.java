package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.service.impl.pojo.User;
import com.shop.service.UserService;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
   private UserService userService;

    @GetMapping("/list")
    public ResultVO getUserList(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        List<User> users=  userService.selectAll(page,limit);
        PageInfo pageInfo = new PageInfo(users);
        return new ResultVO(ResultCode.SUCCESS,(int)pageInfo.getTotal(),users);
    }


    @DeleteMapping("/list/{userId}")
    public ResultVO deleteUser(@PathVariable("userId") Integer userId) {
        int users =userService.deleteByUserId(userId);
        return new ResultVO(ResultCode.SUCCESS,null);
    }








    @PostMapping("/update")
    public ResultVO updateUser(@RequestBody @Valid User record) {
        int users =userService.updateByUserId(record);
        return new ResultVO(ResultCode.SUCCESS,null);
    }

    @GetMapping("/search")
    public ResultVO searchUsers(User user, Integer page, Integer limit) {
        if (user.getUserName().isEmpty()) {
            user.setUserName(null);
        }
        if (user.getEmail().isEmpty()) {
            user.setEmail(null);
        }
        List<User> users = userService.searchUsers(user, page, limit);
        PageInfo pageInfo = new PageInfo(users);
        return new ResultVO(ResultCode.SUCCESS, (int) pageInfo.getTotal(), users);
    }

}
