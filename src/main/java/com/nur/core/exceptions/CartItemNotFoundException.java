package com.nur.core.exceptions;

public class CartItemNotFoundException extends RuntimeException{
    public CartItemNotFoundException(){
        super("Cart item not found!");
    }
}
