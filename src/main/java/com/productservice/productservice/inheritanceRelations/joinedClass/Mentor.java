package com.productservice.productservice.inheritanceRelations.joinedClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_mentors")
public class Mentor extends User {
    private double avgRating;
}
