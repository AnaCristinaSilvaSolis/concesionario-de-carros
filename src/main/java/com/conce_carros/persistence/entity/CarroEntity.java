package com.conce_carros.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de Carro
 */
@Getter
@Setter
@Entity
@Table(name = "carros")
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_carro")
    private Integer codigoCarro;

    @Column(name = "marca_carro_id")
    private Integer marcaCarroId;

    private String referencia;
    private Double precio;

    @Column(name = "anio_modelo")
    private Double anioModelo;

    private String color;

    @Column(name = "numero_caballos_fuerza")
    private Double numeroCaballosFuerza;

    @Column(name = "cantidad_puertas")
    private Integer cantidadPuertas;

    private Double cilindraje;
    private String transmision;

    @Column(name = "tipo_combustible")
    private String tipoCombustible;

    @Column(name = "cantidad_asientos")
    private Integer cantidadAsientos;

    private Integer traccion;
    private String direccion;
    private String categoria;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "marca_carro_id", insertable = false, updatable = false)
    private MarcaCarroEntity marcaCarroEntity;

}
