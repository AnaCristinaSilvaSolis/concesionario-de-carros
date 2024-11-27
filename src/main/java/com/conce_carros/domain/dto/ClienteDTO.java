package com.conce_carros.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de Cliente
 */
@Getter
@Setter
public class ClienteDTO {
    private String cedula;
    private String nombreCompleto;
    private String correo;
    private Double numeroCelular;
    private Integer activo;
    private String contrasenia;
}
