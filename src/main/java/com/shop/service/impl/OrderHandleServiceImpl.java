package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.shop.controller.dao.GameMapper;
import com.shop.controller.dao.OrderItemMapper;
import com.shop.controller.dao.OrderMapper;
import com.shop.controller.dao.ShoppingCartMapper;
import com.shop.exception.CustomizeException;
import com.shop.service.impl.pojo.Game;
import com.shop.service.impl.pojo.Order;
import com.shop.service.impl.pojo.OrderItem;
import com.shop.service.OrderHandleService;
import com.shop.util.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class OrderHandleServiceImpl implements OrderHandleService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Resource
    private GameMapper gameMapper;


    @Override
    public void createOrder(Order order) {


        orderMapper.insert(order);
        if (order.getOrderItems()!=null){
            for (OrderItem orderItem :order.getOrderItems()) {
                orderItem.setOrderId(order.getOrderId());
                orderItemMapper.insert(orderItem);

                shoppingCartMapper.deleteByUserIdAndGameId(order.getUserId(), orderItem.getGameId());

                Game game = gameMapper.selectByGameId(orderItem.getGameId());
                if (game!=null){
                    if(game.getStock()<orderItem.getQuantity()){

                        throw new CustomizeException(ResultCode.FAILED,"商品《"+game.getGameName()+"》的库存不足");
                    }

                    game.setStock(game.getStock()-orderItem.getQuantity());
                    gameMapper.updateByGameId(game);
                }

            }
        }


    }

    @Override
    public int deleteOrderById(Integer orderId) {
        orderMapper.deleteByOrderId(orderId);
        return 0;
    }


    @Override
    public List<Order> getOrdersByUserId(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectByUserId(userId);
        return orders;
    }


    @Override
    public List<Order> getAllOrdersByPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectAll();
        return orders;
    }

    @Override
    public List<Order> getAllOrdersByPage1(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectAll1();
        return orders;
    }
}
