package com.shop.controller.dao;

import com.shop.service.impl.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByUserId(Integer userId);

    int insert(User record);

    User selectByUserId(Integer userId);

    int updateByUserId(User record);

    List<User> selectAll();

    User selectByUserName(String userName);

    List<User> searchUsers(User user);
}
