package com.ezliv.domain.product;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String id) {
        super("Product not found with id: " + id);
    }
}
