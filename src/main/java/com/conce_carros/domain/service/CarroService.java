package com.conce_carros.domain.service;

import com.conce_carros.domain.dto.CarroDTO;
import com.conce_carros.domain.repository.ICarroRepository;
import com.conce_carros.domain.service.useCase.ICarroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarroService implements ICarroUseCase {

    private final ICarroRepository iCarroRepository;

    @Override
    public List<CarroDTO> getAll() {
        return iCarroRepository.getAll();
    }

    @Override
    public List<CarroDTO> getByIdMarcaCarro(Integer marcaCarroId) {
        return iCarroRepository.getByIdMarcaCarro(marcaCarroId);
    }

    @Override
    public List<CarroDTO> getCarrosByLessThan(Double precio) {
        return iCarroRepository.getCarrosByLessThan(precio);
    }

    @Override
    public Optional<CarroDTO> getCarro(Integer codigoCarro) {
        return iCarroRepository.getCarro(codigoCarro);
    }

    @Override
    public Optional<CarroDTO> update(CarroDTO carroUpdate) {
        if(iCarroRepository.getCarro(carroUpdate.getCodigoCarro()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCarroRepository.save(carroUpdate));
    }

    @Override
    public CarroDTO save(CarroDTO newCarro) {
        return iCarroRepository.save(newCarro);
    }

    @Override
    public boolean delete(Integer codigoCarro) {
        if(iCarroRepository.getCarro(codigoCarro).isEmpty()){
            return false;
        }
        iCarroRepository.delete(codigoCarro);
        return true;
    }
}
