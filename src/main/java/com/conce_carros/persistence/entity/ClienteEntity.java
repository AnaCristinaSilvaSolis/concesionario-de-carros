package com.conce_carros.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de Cliente
 */
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    private String cedula;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    private String correo;

    @Column(name = "numero_celular")
    private Double numeroCelular;

    private Integer activo;
    private String contrasenia;

    @OneToMany(mappedBy = "clienteEntity")
    private List<CompraEntity> compraEntity;
}
