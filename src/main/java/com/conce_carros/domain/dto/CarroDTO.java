package com.conce_carros.domain.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO del carro
 */
@Getter
@Setter
public class CarroDTO {

    private Integer codigoCarro;
    private Integer marcaCarroId;
    private String referencia;
    private Double precio;
    private Double anioModelo;
    private String color;
    private Double numeroCaballosFuerza;
    private Integer cantidadPuertas;
    private Double cilindraje;
    private String transmision;
    private String tipoCombustible;
    private Integer cantidadAsientos;
    private Integer traccion;
    private String direccion;
    private String categoria;
    private String rutaImagen;
}

