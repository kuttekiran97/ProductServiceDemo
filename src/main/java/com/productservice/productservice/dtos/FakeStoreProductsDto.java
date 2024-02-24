package com.productservice.productservice.dtos;

import com.productservice.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductsDto {
    private Long id;
    private String title;
    private float price;
    private String category;
    private String description;
    private String image;
}
