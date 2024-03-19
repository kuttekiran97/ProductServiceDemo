package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private int price;

    //Category is a primitive data,Hence we need to find the Cardinality.
    /*
          1             1
        Product  -> Category
          M             1
     */
    @ManyToOne
    private Category category;
}
