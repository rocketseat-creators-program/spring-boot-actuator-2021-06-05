package com.example.actuator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldError {

    private String field;
    private String message;

    public FieldError(org.springframework.validation.FieldError fieldError) {
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }

}
