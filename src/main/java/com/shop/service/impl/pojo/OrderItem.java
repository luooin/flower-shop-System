package com.shop.service.impl.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Integer orderItemId;

    private Integer orderId;

    private Integer gameId;

    private BigDecimal price;

    private Integer quantity;
    private Game game_info;

    public Game getGame_info() {
        return game_info;
    }

    public void setGame_info(Game game_info) {
        this.game_info = game_info;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                ", gameId=" + gameId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", game_info=" + game_info +
                '}';
    }
}
