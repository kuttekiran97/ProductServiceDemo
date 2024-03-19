package com.productservice.productservice.inheritanceRelations.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_Tas")
public class Ta extends User{
    private String ta_session;
}
