package com.productservice.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@Getter
@Setter
public class ExceptionDto {
    private HttpStatus httpStatus;

    private String message;


}
