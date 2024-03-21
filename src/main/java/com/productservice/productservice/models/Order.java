package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
public class Order extends BaseModel{
    /*
            1          M
            Order ----Product  => M:M
               M  ---- 1
     */
    @ManyToMany
    private List<Product> products;

}