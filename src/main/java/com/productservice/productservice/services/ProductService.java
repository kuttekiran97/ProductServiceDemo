package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductsDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    GenericProductDto getProductByID(Long id);
    void getAllProducts();
    void deleteProductByID();
    void createProduct();
    void updateProductByID();

}
