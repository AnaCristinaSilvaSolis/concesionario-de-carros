package com.conce_carros.exception;

public class CompraNotExistException extends RuntimeException{
    public CompraNotExistException(){
        super("La factura no existe.");
    }
}
