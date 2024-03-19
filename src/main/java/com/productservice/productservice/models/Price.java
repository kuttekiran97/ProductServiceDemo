package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "prices")
public class Price extends BaseModel{
    private String currency;
    private Double value;

}
