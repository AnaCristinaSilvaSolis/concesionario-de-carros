package com.conce_carros.exception;


public class CorreoValidationException extends RuntimeException{

    public CorreoValidationException(){
        super("El correo no tiene un formato válido");
    }
}
