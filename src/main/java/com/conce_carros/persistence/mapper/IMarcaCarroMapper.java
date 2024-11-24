package com.conce_carros.persistence.mapper;

import com.conce_carros.domain.pojo.MarcaCarroPojo;
import com.conce_carros.persistence.entity.MarcaCarroEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de MArcaCarro a pojos o entidades
 */

@Mapper(componentModel = "spring")
public interface IMarcaCarroMapper {

    /**
     * Convierte una entidad a un pojo de marca carro
     * @param marcaEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")

    MarcaCarroPojo toMarcaCarroEntity(MarcaCarroEntity marcaEntity);


    /**
     * Convierte un pojo a una entidad de marca carro
     * @param MarcaPojo Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    MarcaCarroEntity toMarcaCarroEntity(MarcaCarroPojo marcaPojo);


    /**
     * Retorna una lista de marcas carro, transformada a Pojo de una lista de entidades
     * @param marcasCarroEntity Entidad a transformar
     * @return Lista transformada
     */
    List<MarcaCarroPojo> toMarcasCarroPojo(List<MarcaCarroEntity> marcasCarroEntity);
}
