package com.productservice.productservice.services;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.dtos.FakeStoreProductsDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
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
import java.util.Objects;

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
    public GenericProductDto getProductByID(Long id) throws ProductNotFoundException {
        //Integrate the Fakestore API
        // Using RestTemplate,we can call external APIs.In our case,its Fakestore API's

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductsDto> responseEntity = restTemplate.getForEntity(specificProductByIDUrl, FakeStoreProductsDto.class,id);

        //Convert FakeStoreProductsDto to GenericProductDto
        FakeStoreProductsDto fakeStoreProductsDto = responseEntity.getBody();
        if(fakeStoreProductsDto==null){
            throw new ProductNotFoundException("Product not found with this id " +  id);
        }
        return convertToGenericProductDto(fakeStoreProductsDto);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        /**
         * Due to Generics Type Erasure we can't use Lise<FakeStoreProductDTO>.class as Response Type.
         * Type information is erased at compile time. This means that at runtime, the JVM does not have access to the generic type parameters due to type erasure.
         * So, RestTemplate won't be able to convert the JSON response to correct Type.
         * Arrays Don't suffer from this problem.
         */

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
    public GenericProductDto updateProductByID(int id, GenericProductDto genericProductDto) {
        /**
         * Return type of DELETE should ideally be just a boolean or a message for successful delete.
         * Since FakeStoreApi is returning the deleted product itself we are also returning the DTO.
         **/

        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpEntity<GenericProductDto> request = new HttpEntity<GenericProductDto>(genericProductDto);
        ResponseEntity<FakeStoreProductsDto> responseEntity = restTemplate.exchange(specificProductByIDUrl, HttpMethod.PUT, request, FakeStoreProductsDto.class,
                id);

        return convertToGenericProductDto(responseEntity.getBody());

        /** Below code didnt work due to some internal HTTP methods

         //FakeStoreProductsDto fakeStoreProductsDto = restTemplate.patchForObject(specificProductByIDUrl,genericProductDto,FakeStoreProductsDto.class,id);

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductsDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductsDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductsDto.class);
       ResponseEntity<FakeStoreProductsDto> responseEntity = restTemplate.execute(specificProductByIDUrl, HttpMethod.PUT, requestCallback, responseExtractor,FakeStoreProductsDto.class,genericProductDto, id);

       return convertToGenericProductDto(responseEntity.getBody());

        **/

    }
}
