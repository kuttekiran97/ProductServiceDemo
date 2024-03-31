package com.productservice.productservice.services;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.Repositories.ProductRepository;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class SelfProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public GenericProductDto getProductByID(Long id) throws ProductNotFoundException {
        //Make a DB call & get the product with given id.
        GenericProductDto genericProductDto = new GenericProductDto();
        Optional<Product> optionalproduct = productRepository.findById(UUID.fromString("a06bde-3787-4199-88a3-98d8d3ccbee7"));
        Product product1 = optionalproduct.get();

        genericProductDto.setDescription(product1.getDescription());
        genericProductDto.setTitle(product1.getTitle());
        genericProductDto.setPrice(0);

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductByID(int id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProductByID(int id, GenericProductDto genericProductDto) {
        return null;
    }
}
