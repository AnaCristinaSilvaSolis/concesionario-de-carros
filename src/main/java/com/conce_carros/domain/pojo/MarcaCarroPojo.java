package com.conce_carros.domain.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca carro
 */
@Getter
@Setter
@Builder
public class MarcaCarroPojo {

    /**
     * id de la marca carro
     */
    private Integer id;

    /**
     * id de la marca carro
     */
    private String description;
}
