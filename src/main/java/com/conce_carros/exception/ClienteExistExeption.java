package com.conce_carros.exception;

public class ClienteExistExeption  extends RuntimeException{

    public ClienteExistExeption(){
        super("El usuario ingresado ya se encuentra registrado.");
    }
}
