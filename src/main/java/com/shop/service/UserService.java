package com.shop.service;

import java.util.List;

import com.shop.service.impl.pojo.User;

public interface UserService {

    int deleteByUserId(Integer userId);

    int insert(User record);

    User selectByUserId(Integer userId);

    int updateByUserId(User record);

    List<User> selectAll(Integer page,Integer limit);



	List<User> searchUsers(User user, Integer page, Integer limit);

}
