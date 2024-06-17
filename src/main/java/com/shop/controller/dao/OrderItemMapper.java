package com.shop.controller.dao;

import com.shop.service.impl.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    int insert(OrderItem record);

    List<OrderItem> selectByOrderId(Integer orderId);

    int updateByOrderIdAndGameId(OrderItem record);
}
