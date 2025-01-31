package com.turkcell.turkcellcqrs.core.exception.type;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationException extends RuntimeException{
    private List<String> errors;

    public ValidationException(List<String> errors) {
        this.errors = errors;
    }
}
