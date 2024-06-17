package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.service.impl.pojo.Order;
import com.shop.service.impl.pojo.User;
import com.shop.service.OrderHandleService;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user_center")
public class UserCenterController {

    @Autowired
    private OrderHandleService orderHandleService;




    @GetMapping("/orders")
    @ResponseBody
    public ResultVO getUserOrders(Integer page,Integer limit,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderHandleService.getOrdersByUserId(user.getUserId(), page, limit);
        PageInfo pageInfo = new PageInfo(orders);
        return new ResultVO(ResultCode.SUCCESS, (int)pageInfo.getTotal(),orders);
    }





    @DeleteMapping("/orders/{orderId}")
    @ResponseBody
    public ResultVO deleteOrder(@PathVariable("orderId") Integer orderId) {
        int orders = orderHandleService.deleteOrderById(orderId);
        return new ResultVO(ResultCode.SUCCESS,null);
    }

}
