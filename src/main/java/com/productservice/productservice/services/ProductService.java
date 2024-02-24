package com.productservice.productservice.services;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.dtos.FakeStoreProductsDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductByID(Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductByID(int id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProductByID(int id, GenericProductDto genericProductDto);

}
