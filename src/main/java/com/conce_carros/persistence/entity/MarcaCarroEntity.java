package com.conce_carros.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "marcaCarroEntity", cascade = {CascadeType.ALL})
    private List<CarroEntity> carroEntities;

}
