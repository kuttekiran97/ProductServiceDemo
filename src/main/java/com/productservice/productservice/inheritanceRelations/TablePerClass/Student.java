package com.productservice.productservice.inheritanceRelations.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TBC_students")
public class Student extends User {
    private double psp;
}
