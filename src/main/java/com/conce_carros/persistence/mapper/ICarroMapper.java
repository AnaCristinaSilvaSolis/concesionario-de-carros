package com.conce_carros.persistence.mapper;

import com.conce_carros.domain.dto.CarroDTO;
import com.conce_carros.persistence.entity.CarroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper de Carro
 */
@Mapper(componentModel = "spring")
public interface ICarroMapper {

    CarroDTO toCarroDTO(CarroEntity carroEntity);

    @Mapping(target = "marcaCarroEntity", ignore = true)
    @Mapping(target = "carroCompraEntity", ignore = true)
    CarroEntity toCarroEntity(CarroDTO carroDTO);

    List<CarroDTO> toCarrosDTO(List<CarroEntity> carroEntityList);
}
