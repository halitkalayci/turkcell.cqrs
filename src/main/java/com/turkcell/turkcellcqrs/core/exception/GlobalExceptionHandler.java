package com.turkcell.turkcellcqrs.core.exception;

import com.turkcell.turkcellcqrs.core.exception.type.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<List<String>> validationException(ValidationException e) {
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
