package com.shop.controller;

import com.shop.exception.CustomizeException;
import com.shop.service.impl.pojo.ShoppingCart;
import com.shop.service.impl.pojo.User;
import com.shop.service.ShoppingCartService;
import com.shop.util.ResultCode;
import com.shop.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/list")
    public ResultVO getCartByUserId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<ShoppingCart> carts = shoppingCartService.getShoppingCartsByUserId(user.getUserId());
        return new ResultVO(ResultCode.SUCCESS, carts);
    }


    @PutMapping("/list/{cartId}")
    public ResultVO updateCartItem(@PathVariable("cartId") Integer cartId,Integer quantity) {
        if(quantity<=0){
            throw new CustomizeException(ResultCode.FAILED,"购物数量必须大于0");
        }
        if(quantity>10){
            throw new CustomizeException(ResultCode.FAILED,"每件商品限购10件");
        }
        ShoppingCart cart = new ShoppingCart();
        cart.setCartId(cartId);
        cart.setQuantity(quantity);
        shoppingCartService.updateShoppingCart(cart);
        return new ResultVO(ResultCode.SUCCESS);
    }


    @PostMapping("/list")
    public ResultVO addToShoppingCart(@Valid ShoppingCart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cart.setUserId(user.getUserId());
        shoppingCartService.addToShoppingCart(cart);
        return new ResultVO(ResultCode.SUCCESS);
    }


    @DeleteMapping("/list/{cartId}")
    public ResultVO deleteCartItem(@PathVariable("cartId") Integer cartId) {
        shoppingCartService.deleteShoppingCartByCartId(cartId);
        return new ResultVO(ResultCode.SUCCESS);
    }


    @DeleteMapping("/list")
    public ResultVO deleteCartItem(@RequestBody int[] cartIds) {
        shoppingCartService.deleteShoppingCarts(cartIds);
        return new ResultVO(ResultCode.SUCCESS);
    }


}
