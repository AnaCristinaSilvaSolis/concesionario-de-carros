package com.conce_carros.persistence.mapper;


import com.conce_carros.domain.dto.ClienteDTO;
import com.conce_carros.domain.dto.compras.CompraRequestDTO;
import com.conce_carros.persistence.entity.ClienteEntity;
import com.conce_carros.persistence.entity.CompraEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper de compras
 */
@Mapper(componentModel = "spring")
public interface ICompraMapper {


    CompraRequestDTO toCompraRequestDTO(CompraEntity compraEntity);

    @InheritInverseConfiguration
    @Mapping(target = "clienteEntity", ignore = true)
    CompraEntity toCompraEntity(CompraRequestDTO compraRequestDTO);

    List<CompraRequestDTO> toComprasRequestDTO(List<CompraEntity> compraEntityList);
}
