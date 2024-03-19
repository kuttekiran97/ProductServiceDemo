package com.productservice.productservice.inheritanceRelations.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_students")
public class Student extends User{
    private double psp;
}
