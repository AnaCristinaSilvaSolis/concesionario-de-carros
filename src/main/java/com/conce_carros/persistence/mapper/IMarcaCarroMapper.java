package com.conce_carros.persistence.mapper;

import com.conce_carros.domain.dto.MarcaCarroDTO;
import com.conce_carros.persistence.entity.MarcaCarroEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de MarcaCarro a dto o entidades
 */

@Mapper(componentModel = "spring")
public interface IMarcaCarroMapper {

    /**
     * Convierte una entidad a un dto de marca carro
     * @param marcaEntity Entidad a convertir
     * @return DTO convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCarroDTO toMarcaCarroDTO(MarcaCarroEntity marcaEntity);


    /**
     * Convierte un dto a una entidad de marca carro
     * @param marcaDTO Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    MarcaCarroEntity toMarcaCarroEntity(MarcaCarroDTO marcaDTO);


    /**
     * Retorna una lista de marcas carro, transformada a Pojo de una lista de entidades
     * @param marcasCarroEntity Entidad a transformar
     * @return Lista transformada
     */
    List<MarcaCarroDTO> toMarcasCarroDTO(List<MarcaCarroEntity> marcasCarroEntity);
}
