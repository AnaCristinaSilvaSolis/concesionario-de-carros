package com.conce_carros.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de marca carro
 */
@Getter
@Setter
@Entity
@Table(name = "marca_carro")
public class MarcaCarroEntity {

    /**
     * id de la marca carro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Integer id;

    /**
     * descripcion de la marca carro
     */
    @Column(name = "descripcion")
    private String description;
}
