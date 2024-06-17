package com.shop.service.impl;

import com.shop.controller.dao.ShoppingCartMapper;
import com.shop.exception.CustomizeException;
import com.shop.service.impl.pojo.ShoppingCart;
import com.shop.service.ShoppingCartService;
import com.shop.util.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;


    @Override
    public int addToShoppingCart(ShoppingCart cart) {
        ShoppingCart record = shoppingCartMapper.selectByUserIdAndGameId(cart.getUserId(), cart.getGameId());
        if (record != null) {

            throw new CustomizeException(ResultCode.FAILED, "您已经添加过该商品了,不能重复添加哦");
        }
        return shoppingCartMapper.insert(cart);
    }


    @Override
    public int deleteShoppingCarts(int[] cartIds) {
        int total=0;
        for (Integer cartId:cartIds) {
            total += deleteShoppingCartByCartId(cartId);
        }
        return total;
    }


    @Override
    public int deleteShoppingCartByCartId(Integer cartId) {
        return shoppingCartMapper.deleteByCartId(cartId);
    }


    @Override
    public int updateShoppingCart(ShoppingCart cart) {
        return shoppingCartMapper.updateByByCartId(cart);
    }


    @Override
    public List<ShoppingCart> getShoppingCartsByUserId(Integer userId) {
        List<ShoppingCart> carts = shoppingCartMapper.selectByUserId(userId);
        return carts;
    }
}
