package com.conce_carros.exception;

public class NoAutorizadoException extends RuntimeException{
    public NoAutorizadoException(){
        super("No tiene los permisos necesarios.");
    }
}
