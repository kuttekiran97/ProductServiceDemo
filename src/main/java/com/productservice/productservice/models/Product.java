package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;

    //Category is a primitive data,Hence we need to find the Cardinality.
    /*
          1             1
        Product  -> Category
          M             1
     */
    @ManyToOne(optional = false)
    private Category category;

    /*
            1       1
        Product ----Price     => 1:1   => can be M:1, depend on requirement.For now we considered,1:1.
          1     ----  1
     */
    @OneToOne(optional = false,cascade = CascadeType.PERSIST)
    private Price price;

}
