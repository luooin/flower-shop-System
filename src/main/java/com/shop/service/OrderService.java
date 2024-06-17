package com.shop.service;

import java.util.List;

import com.shop.service.impl.pojo.Order;

public interface OrderService {
    int deleteByOrderId(Integer orderId);

    int insert(Order record);

    Order selectByOrderId(Integer orderId);

    int updateByOrderId(Order record);

    List<Order> selectAll();

    List<Order> selectByUserId(Integer userId);




    List<Order> searchOrders(Order order,Integer page,Integer limit);
}
