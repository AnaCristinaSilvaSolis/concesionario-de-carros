package com.conce_carros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(CorreoValidationException.class)
    public ResponseEntity<Map<String, String>> correoException (CorreoValidationException correoValidationException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap("ERROR", correoValidationException.getMessage()));
    }
}