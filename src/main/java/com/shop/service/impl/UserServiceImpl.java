package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import com.shop.controller.dao.UserMapper;
import com.shop.service.impl.pojo.User;
import com.shop.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
	@Override
	public int deleteByUserId(Integer userId) {

		int users= userMapper.deleteByUserId(userId);
		return users;
	}

	@Override
	public int insert(User record) {

		int users = userMapper.insert(record);
		return users;
	}

	@Override
	public User selectByUserId(Integer userId) {

		User users = userMapper.selectByUserId(userId);
		return users;
	}

	@Override
	public int updateByUserId(User record) {

		int users= userMapper.updateByUserId(record);
		return users;
	}

	@Override
	public List<User> selectAll(Integer page,Integer limit) {

		PageHelper.startPage(page,limit);
		List<User> users=userMapper.selectAll();
		return users;
	}



	@Override
	public List<User> searchUsers(User user, Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		List<User> users = userMapper.searchUsers(user);
		return users;
	}
}
