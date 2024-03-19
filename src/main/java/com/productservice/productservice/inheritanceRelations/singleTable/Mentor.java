package com.productservice.productservice.inheritanceRelations.singleTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ST_mentors")
public class Mentor extends User {
    private double avgRating;
}
