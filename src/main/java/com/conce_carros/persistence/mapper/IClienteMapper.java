package com.conce_carros.persistence.mapper;

import com.conce_carros.domain.dto.ClienteDTO;
import com.conce_carros.persistence.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper de cliente
 */
@Mapper(componentModel = "spring")
public interface IClienteMapper {

    ClienteDTO toClienteDTO(ClienteEntity clienteEntity);

    @InheritInverseConfiguration
    @Mapping(target = "compraEntity", ignore = true)
    ClienteEntity toClienteEntity(ClienteDTO clienteDTO);

    List<ClienteDTO> toClientesDTO(List<ClienteEntity> clienteEntityList);
}
