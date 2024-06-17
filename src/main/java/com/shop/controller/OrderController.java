package com.shop.controller;

import com.shop.service.impl.pojo.Order;
import com.shop.service.impl.pojo.User;
import com.shop.service.OrderHandleService;
import com.shop.service.OrderService;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping("/order")
public class OrderController {
     @Autowired
     private OrderService orderService;

    @Autowired
    private OrderHandleService orderHandleService;


    @GetMapping("/list")
    public ResultVO getOrderList(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit) {
        List<Order> orders = orderHandleService.getAllOrdersByPage(page, limit);
        PageInfo pageInfo = new PageInfo(orders);
        return new ResultVO(ResultCode.SUCCESS,(int)pageInfo.getTotal(),orders);
    }

    @GetMapping("/list1")
    public ResultVO getOrderList1(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit) {
        List<Order> orders = orderHandleService.getAllOrdersByPage1(page, limit);
        PageInfo pageInfo = new PageInfo(orders);
        return new ResultVO(ResultCode.SUCCESS,(int)pageInfo.getTotal(),orders);
    }
    @PostMapping("/submit")
    public ResultVO orderSubmit(@RequestBody @Valid Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (order.getUserId()!=null&&order.getUserId()==0){

        }else{
            order.setUserId(user.getUserId());
        }

        orderHandleService.createOrder(order);
        return new ResultVO(ResultCode.SUCCESS,"/"+user.getUserName()+"/orders");
    }


    @PutMapping("/list/{orderId}")
    public ResultVO updateOrder(@PathVariable("orderId") Integer orderId,@RequestBody Order order) {
           Order orders1 = orderService.selectByOrderId(orderId);
           if(orders1!=null)
           {
        	order.setOrderId(orderId);
        	int orders = orderService.updateByOrderId(order);
        	return new ResultVO(ResultCode.SUCCESS,null);
           }
           else
        	return new ResultVO(ResultCode.RECORD_NOT_FOUND,null);
    }


    @DeleteMapping("/list/{orderId}")
    public ResultVO deleteOrder(@PathVariable("orderId") Integer orderId) {
    	int orders = orderService.deleteByOrderId(orderId);
        return new ResultVO(ResultCode.SUCCESS,null);
    }




    @GetMapping("/list/{orderId}")
        public ResultVO getOrderByOrderId(@PathVariable("orderId") Integer orderId) {
    	Order orders = orderService.selectByOrderId(orderId);
    	if(orders!=null)
        return new ResultVO(ResultCode.SUCCESS,orders);
    	else
    	return new ResultVO(ResultCode.RECORD_NOT_FOUND,null);
    }


    @GetMapping("/search")
    public ResultVO searchOrders(Order order, Integer page, Integer limit) {
        if (order.getConsigneeName().isEmpty()) {
            order.setConsigneeName(null);
        }
        List<Order> orders = orderService.searchOrders(order, page, limit);
        PageInfo pageInfo = new PageInfo(orders);
        return new ResultVO(ResultCode.SUCCESS, (int) pageInfo.getTotal(), orders);
    }

}
