package com.nur.api;

import com.nur.business.abstracts.CartService;
import com.nur.business.dto.requests.create.CreateCartItemRequest;
import com.nur.business.dto.responses.get.GetAllCartsResponse;
import com.nur.business.dto.responses.get.GetCartResponse;
import com.nur.entities.Cart;
import com.nur.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/carts")
public class CartsController {
    private final CartService service;

    @GetMapping
    public List<GetAllCartsResponse> getAll(){
        return service.getAll();
    }

    @PutMapping("/empty-cart/{cartId}")
    public void emptyCart(@PathVariable Long cartId){
        service.emptyCart(cartId);
    }

    @PutMapping("/create-cart")
    public Cart createCart(){
        return service.createCart();
    }

    @PutMapping("/update-cart")
    public Cart updateCart(@PathVariable Cart cart){
        return service.updateCart(cart);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
