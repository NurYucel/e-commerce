package com.nur.core.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(){
        super("Product not found with id: ");
    }
}
