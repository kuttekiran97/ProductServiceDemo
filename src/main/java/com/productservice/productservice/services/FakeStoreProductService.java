package com.productservice.productservice.services;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.dtos.FakeStoreProductsDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Primary
@Service("FakeStoreProductService")  //This annotation creates an object automatically by spring and passes to the constructor
public class FakeStoreProductService implements ProductService {

    private FakeStoreClientAdapter fakeStoreAdapter;


    public FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter) {

        this.fakeStoreAdapter = fakeStoreAdapter;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductsDto fakeStoreProductsDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductsDto.getId());
        genericProductDto.setTitle(fakeStoreProductsDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductsDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductsDto.getCategory());
        genericProductDto.setImage(fakeStoreProductsDto.getImage());
        genericProductDto.setPrice(fakeStoreProductsDto.getPrice());

        return genericProductDto;
    }


    @Override
    public GenericProductDto getProductByID(Long id) throws ProductNotFoundException {
        return convertToGenericProductDto(fakeStoreAdapter.getProductByID(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<FakeStoreProductsDto> fakeStoreProductsDtos = fakeStoreAdapter.getAllProducts();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductsDto fakeStoreProductsDto : fakeStoreProductsDtos) {
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductsDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto deleteProductByID(int id) {
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductByID(id));
    }

    @Override
    public GenericProductDto updateProductByID(int id, GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.updateProductByID(id, genericProductDto));
    }
}
