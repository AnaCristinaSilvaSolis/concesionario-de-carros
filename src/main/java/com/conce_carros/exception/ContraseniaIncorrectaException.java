package com.conce_carros.exception;

public class ContraseniaIncorrectaException extends RuntimeException{

    public ContraseniaIncorrectaException(){
        super("La contraseña es inválida.");
    }
}
