package com.shop.controller.dao;

import com.shop.service.impl.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartMapper {
    int deleteByCartId(Integer cartId);

    int insert(ShoppingCart record);

    ShoppingCart selectByCartId(Integer cartId);

    int updateByByCartId(ShoppingCart record);

    int updateByUserIdAndGameId(ShoppingCart record);

    List<ShoppingCart> selectByUserId(Integer userId);

    ShoppingCart selectByUserIdAndGameId(Integer userId,Integer gameId);

    int deleteByUserIdAndGameId(Integer userId, Integer gameId);

}
