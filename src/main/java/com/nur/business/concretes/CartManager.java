package com.nur.business.concretes;

import com.nur.business.abstracts.CartItemService;
import com.nur.business.abstracts.CartService;

import com.nur.business.dto.responses.get.GetAllCartsResponse;
import com.nur.entities.Cart;
import com.nur.entities.CartItem;
import com.nur.entities.Customer;
import com.nur.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartManager implements CartService {
    private final CartRepository repository;
    private final CartItemService cartItemService;
    private ModelMapper mapper;

    @Override
    public List<GetAllCartsResponse> getAll(){
        List<Cart> carts = repository.findAll();
        return carts
                .stream()
                .map(cart -> mapper.map(cart,GetAllCartsResponse.class))
                .toList();
    }

    @Override
    public Cart getCart(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        cart.setCartItems(new ArrayList<>());
        return repository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void emptyCart(Long cartId) {
        Cart cart = repository.findById(cartId).orElseThrow();
        List<CartItem> cartItems = cart.getCartItems();
        for (int i = 0 ; i < cartItems.size() ; i++){
            cartItems.get(i).setCart(null);
            cartItems.clear();
        }
        cart.setCartItems(cartItems);
        cart.setTotalPrice(0);
        repository.save(cart);
    }

    @Override
    public void setUserForCart(Cart cart, Customer customer) {
        cart.setCustomer(customer);
        repository.save(cart);
    }

}
