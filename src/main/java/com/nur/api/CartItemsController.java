package com.nur.api;

import com.nur.business.abstracts.CartItemService;
import com.nur.business.dto.requests.create.CreateCartItemRequest;
import com.nur.business.dto.responses.get.GetAllCartItemsResponse;
import com.nur.entities.Cart;
import com.nur.entities.CartItem;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cartItems")
public class CartItemsController {
    private final CartItemService service;

    @GetMapping
    public List<GetAllCartItemsResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CartItem getCartItemById(Long id){
        return service.getCartItemById(id);
    }

    @PutMapping("/add-to-cart-item")
    public void addProductToCart(@PathVariable Long cartId,@PathVariable Long productId,@PathVariable int quantity){
        service.addProductToCart(cartId,productId,quantity);
    }
    @PutMapping("/remove-product-from-cart")
    public void removeProductFromCart(@PathVariable Long cartId,@PathVariable Long productId){
        service.removeProductFromCart(cartId, productId);
    }

    @PutMapping("/delete-from/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/create-cart-item")
    public CartItem createCartItem(@RequestBody CreateCartItemRequest cartItem){
        return service.createCartItem(cartItem);
    }

    @PutMapping("/set-cart-for-cart-item")
    public void setCartForCartItem(@RequestBody CartItem cartItem, @RequestBody Cart cart){
        service.setCartForCartItem(cartItem,cart);
    }

}
