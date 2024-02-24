package com.productservice.productservice.Exceptions;

import com.productservice.productservice.services.ProductService;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}
