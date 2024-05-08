package com.nur.business.abstracts;

import com.nur.business.dto.requests.create.CreateCartItemRequest;
import com.nur.business.dto.responses.get.GetAllCartItemsResponse;
import com.nur.entities.Cart;
import com.nur.entities.CartItem;

import java.util.List;

public interface CartItemService {
    void addProductToCart(Long cartId, Long productID, int quantity);
    void removeProductFromCart(Long cartId, Long productId);
    List<GetAllCartItemsResponse> getAll();
    CartItem getCartItemById(Long id);
    void delete(Long id);
    CartItem createCartItem(CreateCartItemRequest request);
    void setCartForCartItem(CartItem cartItem, Cart cart);

}
