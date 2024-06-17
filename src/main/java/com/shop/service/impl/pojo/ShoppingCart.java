package com.shop.service.impl.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ShoppingCart {
    private Integer cartId;

    private Integer userId;

    @NotNull(message = "商品ID不能为空")
    private Integer gameId;

    private BigDecimal price;

    @Min(value = 1,message = "购买数量不能小于或等于0")
    @Max(value = 10,message = "每个用户限购10件")
    private Integer quantity;

    private Game game_info;

    public Game getGame_info() {
        return game_info;
    }

    public void setGame_info(Game game_info) {
        this.game_info = game_info;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
