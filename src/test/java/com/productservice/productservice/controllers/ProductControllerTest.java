package com.productservice.productservice.controllers;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;
    @Autowired
    private FakeStoreClientAdapter fakeStoreClientAdapter;


    @MockBean  /*Here we are not using Autowired since we don't want to create actual object.
                So we want Mocked dependency that we are only using in this class.*/
    private ProductService productService;

    @Test
    @DisplayName("1+1=2")
    void onePlusOneTwo(){
        assertEquals(2,1+1);
    }
    @Test
    void checkForTrue(){
        assertTrue(1==1);
        assertFalse(false);
    }

    @Test
    void testGetProductBbyIDNegativeTC() throws ProductNotFoundException {
        assertThrows(ProductNotFoundException.class,()->productController.getProductByID(100000L));
    }
    @Test
    void testGetProductBbyIDNullTC() throws ProductNotFoundException {
        assertNull(fakeStoreClientAdapter.getProductByID(100000L)); //If we return Null,when if is not found
    }

    /*Below are Test cases are related to actual Product controller*/
    @Test
    void  testGetProductByIDMocking() throws ProductNotFoundException {
        when(productService.getProductByID(1000L)).thenReturn(null);  //Mocked the ProductService
        assertNull(productController.getProductByID(1000L)); //Tested ProductController

        GenericProductDto genericProductDto=new GenericProductDto();
        when(productService.getProductByID(1000L)).thenReturn(genericProductDto);  //Mocked the ProductService
        assertEquals(genericProductDto,productController.getProductByID(1000L)); //Tested ProductController

        when(productService.getProductByID(1000L)).thenThrow(ProductNotFoundException.class);  //Mocked the ProductService
        assertThrows(ProductNotFoundException.class,()->productController.getProductByID(1000L)); //Tested ProductController
    }


}
