package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductsDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductByID(Long id);
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductByID(int id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    void updateProductByID();

}
