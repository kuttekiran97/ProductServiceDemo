package com.productservice.productservice.controllers;

import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public String getProductByID(@PathVariable("id") Long id){
        return productService.getProductByID(id);

    }
    @GetMapping
    public void getAllProducts(){

    }

   // @DeleteMapping("/products/{id}")
    @DeleteMapping("/{id}")
    public void deleteProductByID(){

    }

    public void createProduct(){

    }
    public void updateProductByID(){

    }

}
