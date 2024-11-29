package com.conce_carros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(
            {CorreoValidationException.class,
                    ClienteExistExeption.class,
                    ClienteNotExistExeption.class,
                    CompraNotExistException.class, ContraseniaIncorrectaException.class, NoAutorizadoException.class})
    public ProblemDetail exceptionBadRequest(RuntimeException runtimeException){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
    }
}
