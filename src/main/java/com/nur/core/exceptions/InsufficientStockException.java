package com.nur.core.exceptions;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(){
        super("Insufficient stock for product with id: ");
    }
}
