package com.conce_carros.domain.repository;

import com.conce_carros.domain.dto.CarroDTO;
import com.conce_carros.domain.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de carro
 */
public interface ICarroRepository {

    List<CarroDTO> getAll();

    List<CarroDTO> getByIdMarcaCarro(Integer marcaCarroId);

    List<CarroDTO> getCarrosByLessThan(Double precio);

    Optional<CarroDTO> getCarro(Integer codigoCarro);

    CarroDTO save(CarroDTO newCarro);

    void delete(Integer codigoCarro);
}
