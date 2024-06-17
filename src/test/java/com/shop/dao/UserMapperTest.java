package com.shop.dao;

import com.shop.controller.dao.UserMapper;
import com.shop.service.impl.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/6/4 11:08
 */
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectByUserName(){
        User user =userMapper.selectByUserName("张三d");
        assertEquals(null,user);

    }
}
