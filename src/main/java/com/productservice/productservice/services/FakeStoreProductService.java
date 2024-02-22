package com.productservice.productservice.services;

import org.springframework.stereotype.Service;

@Service("FakeStoreProductService")  //This annotation creates an object automatically by spring and passes to the constructor
public class FakeStoreProductService implements ProductService{

    @Override
    public String getProductByID(Long id) {
        return "Hello, godddddd nyt";
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductByID() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductByID() {

    }
}
