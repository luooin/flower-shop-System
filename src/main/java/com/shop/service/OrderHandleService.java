package com.shop.service;

import com.shop.service.impl.pojo.Order;

import java.util.List;


public interface OrderHandleService {


    void createOrder(Order order);


    int deleteOrderById(Integer orderId);



   List<Order> getOrdersByUserId(Integer userId,Integer page ,Integer limit);


    List<Order> getAllOrdersByPage(Integer page, Integer limit);
    List<Order> getAllOrdersByPage1(Integer page, Integer limit);
}
