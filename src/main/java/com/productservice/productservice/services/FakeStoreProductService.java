package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductsDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")  //This annotation creates an object automatically by spring and passes to the constructor
public class FakeStoreProductService implements ProductService{

    RestTemplateBuilder restTemplateBuilder;
    private String url = "https://fakestoreapi.com/products/1";

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductsDto fakeStoreProductsDto){
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
    public GenericProductDto getProductByID(Long id) {
        //Integrate the Fakestore API
        // Using RestTemplate,we can call external APIs.In our case,its Fakestore API's

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductsDto> responseEntity = restTemplate.getForEntity(url, FakeStoreProductsDto.class);

        //Convert FakeStoreProductsDto to GenericProductDto
        FakeStoreProductsDto fakeStoreProductsDto = responseEntity.getBody();
        return convertToGenericProductDto(fakeStoreProductsDto);
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
