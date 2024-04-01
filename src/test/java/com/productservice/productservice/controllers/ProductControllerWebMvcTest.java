package com.productservice.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//It won't initialize the unnecessary dependencies.

@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {
    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; //Converting object to Json string





    @Test
    void testGetAllProductsReturnsEmptyList() throws Exception {
        //Possible test cases : Empty,valid
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());//Mocked ProductService
        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetAllProductsReturnsValidList() throws Exception {
        //Possible test cases : Empty,valid
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());


        when(productService.getAllProducts()).thenReturn(genericProductDtos);//Mocked ProductService
        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
    }


    @Test
    /*To make this method Run,we have to add @EqualsAndHashCode in GenericProductDto class,
      because in this method we are comparing the objects*/
    void testCreateProductShouldCreateValidNewProduct() throws Exception {
        //Possible test cases : Empty,valid
        //
        GenericProductDto productToCreateDto = new GenericProductDto();
        productToCreateDto.setTitle("Macbook");
        productToCreateDto.setPrice(20000);
        productToCreateDto.setDescription("Fastest Mac ever");
        productToCreateDto.setCategory("Laptop");

        GenericProductDto outputGenericProductDTO = new GenericProductDto();
        outputGenericProductDTO.setCategory(productToCreateDto.getCategory());
        outputGenericProductDTO.setDescription(productToCreateDto.getDescription());
        outputGenericProductDTO.setPrice(productToCreateDto.getPrice());
        outputGenericProductDTO.setTitle(productToCreateDto.getTitle());
        outputGenericProductDTO.setId(1000L);

        when(productService.createProduct(productToCreateDto)).thenReturn(outputGenericProductDTO);//Mocked ProductService
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productToCreateDto))
                )
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(outputGenericProductDTO)))
                .andExpect(jsonPath("$.title", is("Macbook")))//We can also compare the Json data using Hamcrest and AsserJ
                .andExpect(jsonPath("$.price", is(20000)));;
    }
/*

{ $
    student: {
        id:"1",
        "name":"Deepak",
        psp:
    }
}

 */

}
