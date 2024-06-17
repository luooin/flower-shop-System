package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import com.shop.controller.dao.OrderMapper;
import com.shop.service.impl.pojo.Order;
import com.shop.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
	@Override
	public int deleteByOrderId(Integer orderId) {

		int orders = orderMapper.deleteByOrderId(orderId);
		return 0;
	}

	@Override
	@Deprecated
	public int insert(Order record) {

		return 0;
	}

	@Override
	public Order selectByOrderId(Integer orderId) {

		Order orders = orderMapper.selectByOrderId(orderId);
		if(orders!=null)
		return orders;
		else
		return null;
	}

	@Override
	public int updateByOrderId(Order record) {

		int orders = orderMapper.updateByOrderId(record);
		return orders;
	}

	@Override
	public List<Order> selectAll() {

		List<Order> orders = orderMapper.selectAll();
		return orders;
	}

	@Override
	public List<Order> selectByUserId(Integer userId) {

		List<Order> orders = orderMapper.selectByUserId(userId);
		return orders;
	}




	@Override
	public List<Order> searchOrders(Order order, Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		List<Order> orders = orderMapper.searchOrders(order);
		return orders;
	}
}
