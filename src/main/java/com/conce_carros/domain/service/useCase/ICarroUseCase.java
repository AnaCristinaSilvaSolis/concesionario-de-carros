package com.conce_carros.domain.service.useCase;

import com.conce_carros.domain.dto.CarroDTO;

import java.util.List;
import java.util.Optional;

public interface ICarroUseCase {

    List<CarroDTO> getAll();

    List<CarroDTO> getByIdMarcaCarro(Integer marcaCarroId);

    List<CarroDTO> getCarrosByLessThan(Double precio);

    Optional<CarroDTO> getCarro(Integer codigoCarro);

    Optional<CarroDTO> update(CarroDTO carroUpdate);

    CarroDTO save(CarroDTO newCarro);

    boolean delete(Integer codigoCarro);
}

