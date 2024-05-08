package com.nur.core.exceptions;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(){
        super("Cart not found!");
    }
}
