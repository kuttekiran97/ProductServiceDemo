package com.productservice.productservice.inheritanceRelations.singleTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ST_students")
public class Student extends User {
    private double psp;
}
