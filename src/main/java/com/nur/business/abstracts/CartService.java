package com.nur.business.abstracts;

import com.nur.business.dto.responses.get.GetAllCartsResponse;
import com.nur.entities.Cart;
import com.nur.entities.Customer;

import java.util.List;

public interface CartService {
    List<GetAllCartsResponse> getAll();
    Cart getCart(Long id);
    Cart createCart();
    Cart updateCart(Cart cart);
    void delete(Long id);
    void emptyCart(Long id);

    void setUserForCart(Cart cart, Customer customer);

}
