package com.productservice.productservice.controllers;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;
    @Autowired
    private FakeStoreClientAdapter fakeStoreClientAdapter;

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


}
