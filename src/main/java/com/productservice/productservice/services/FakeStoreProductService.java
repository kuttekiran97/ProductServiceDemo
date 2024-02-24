package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductsDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("FakeStoreProductService")  //This annotation creates an object automatically by spring and passes to the constructor
public class FakeStoreProductService implements ProductService{

    RestTemplateBuilder restTemplateBuilder;
    private String specificProductByIDUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductsUrl = "https://fakestoreapi.com/products";


    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){

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
        ResponseEntity<FakeStoreProductsDto> responseEntity = restTemplate.getForEntity(specificProductByIDUrl, FakeStoreProductsDto.class,id);

        //Convert FakeStoreProductsDto to GenericProductDto
        FakeStoreProductsDto fakeStoreProductsDto = responseEntity.getBody();
        return convertToGenericProductDto(fakeStoreProductsDto);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductsDto[]>  responseEntity  =restTemplate.getForEntity(genericProductsUrl, FakeStoreProductsDto[].class);

        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductsDto> fakeStoreProductsDtos = List.of(responseEntity.getBody());
        for(FakeStoreProductsDto fakeStoreProductsDto : fakeStoreProductsDtos){
            result.add(convertToGenericProductDto(fakeStoreProductsDto));
        }
        return result;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductsDto> responseEntity = restTemplate.postForEntity(genericProductsUrl,genericProductDto,FakeStoreProductsDto.class);

        return convertToGenericProductDto(responseEntity.getBody());

        /**  We can also do like below by directly using GenricProductDTO as response type:
        ResponseEntity<GenericProductDto> responseEntity = restTemplate.postForEntity(genericProductsUrl,genericProductDto,GenericProductDto.class);

        //return convertToGenericProductDto(responseEntity.getBody());
        return responseEntity.getBody();
         **/
    }

    @Override
    public GenericProductDto deleteProductByID(int id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductsDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductsDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductsDto.class);
        ResponseEntity<FakeStoreProductsDto> responseEntity = restTemplate.execute(specificProductByIDUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public void updateProductByID() {

    }
}
