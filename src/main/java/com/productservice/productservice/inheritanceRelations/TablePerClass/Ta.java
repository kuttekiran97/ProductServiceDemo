package com.productservice.productservice.inheritanceRelations.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TBC_Tas")
public class Ta extends User {
    private String ta_session;
}
