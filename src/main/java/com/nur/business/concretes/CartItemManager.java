package com.nur.business.concretes;

import com.nur.business.abstracts.CartItemService;
import com.nur.business.abstracts.ProductService;
import com.nur.business.dto.requests.create.CreateCartItemRequest;
import com.nur.business.dto.responses.get.GetAllCartItemsResponse;
import com.nur.core.exceptions.CartItemNotFoundException;
import com.nur.core.exceptions.CartNotFoundException;
import com.nur.core.exceptions.InsufficientStockException;
import com.nur.core.exceptions.ProductNotFoundException;
import com.nur.entities.Cart;
import com.nur.entities.CartItem;
import com.nur.entities.Product;
import com.nur.repository.CartItemRepository;
import com.nur.repository.CartRepository;
import com.nur.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CartItemManager implements CartItemService {
    private final ModelMapper mapper;
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Override
    public void addProductToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);

        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        //check if product is available stock
        if(product.getStock() < quantity) {
            throw new InsufficientStockException();
        }

        //update product stock
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        //create new cart item
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeProductFromCart(Long cartId, Long productId) {
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cartId,productId)
                .orElseThrow(CartItemNotFoundException::new);

        //update product stock
        Product product = cartItem.getProduct();
        product.setStock(product.getStock() + cartItem.getQuantity());
        productRepository.save(product);

        //delete cart item
        cartItemRepository.delete(cartItem);
    }

    @Override
    public List<GetAllCartItemsResponse> getAll() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems
                .stream()
                .map(cartItem -> mapper.map(cartItem,GetAllCartItemsResponse.class))
                .toList();
    }

    @Override
    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public CartItem createCartItem(CreateCartItemRequest request) {
        CartItem cartItem = new CartItem();
        Product product = productService.getProduct(request.getProductId());
        cartItem.setProduct(product);
        cartItem.setPrice(product.getPrice());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void setCartForCartItem(CartItem cartItem, Cart cart) {
        cartItem.setCart(cart);
        cartItemRepository.save(cartItem);
    }
}
