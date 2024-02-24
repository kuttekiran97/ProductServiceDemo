package com.productservice.productservice.controllers;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    //@GetMapping("/products/{id}")  => Since endpoint is same i.e products,
    // we can make it a common as @RequestMapping("/products")

    //localhost:8080/products/123(id)
    @GetMapping("/{id}")
    public GenericProductDto getProductByID(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductByID(id);

    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

   // @DeleteMapping("/products/{id}")
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductByID(@PathVariable("id") int id){
        return productService.deleteProductByID(id);
    }


    @PutMapping("/{id}")
    public GenericProductDto updateProductByID(@PathVariable("id") int id,@RequestBody GenericProductDto genericProductDto){
        return productService.updateProductByID(id,genericProductDto);
    }


    //Below code is moved to ProductControllerDevices

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//
//        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
//        return responseEntity;
//
//    }

}
