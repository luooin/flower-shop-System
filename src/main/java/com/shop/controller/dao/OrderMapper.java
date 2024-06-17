package com.shop.controller.dao;

import com.shop.service.impl.pojo.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByOrderId(Integer orderId);

    int insert(Order record);

    Order selectByOrderId(Integer orderId);

    int updateByOrderId(Order record);

    List<Order> selectAll();

    List<Order> selectByUserId(Integer userId);

    List<Order> searchOrders(Order order);

    List<Order> selectAll1();
}
