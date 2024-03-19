package com.productservice.productservice.inheritanceRelations.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TBC_mentors")
public class Mentor extends User {
    private double avgRating;
}
