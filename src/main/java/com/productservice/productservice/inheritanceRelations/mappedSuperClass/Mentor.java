package com.productservice.productservice.inheritanceRelations.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_mentors")
public class Mentor extends User{
    private double avgRating;
}
