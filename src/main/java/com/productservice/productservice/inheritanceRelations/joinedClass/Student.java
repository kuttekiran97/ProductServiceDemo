package com.productservice.productservice.inheritanceRelations.joinedClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_students")
public class Student extends User {
    private double psp;
}
