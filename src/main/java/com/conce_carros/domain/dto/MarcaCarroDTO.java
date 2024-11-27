package com.conce_carros.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca carro
 */
@Getter
@Setter
public class MarcaCarroDTO {

    /**
     * id de la marca carro
     */
    private Integer id;

    /**
     * id de la marca carro
     */
    private String description;
}
