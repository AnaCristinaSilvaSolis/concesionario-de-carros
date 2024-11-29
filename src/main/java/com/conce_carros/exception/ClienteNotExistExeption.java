package com.conce_carros.exception;

public class ClienteNotExistExeption extends RuntimeException{
    public ClienteNotExistExeption(){
        super("El usuario ingresado no existe.");
    }
}
