package com.conce_carros.persistence.repository;

import com.conce_carros.domain.dto.CarroDTO;
import com.conce_carros.domain.repository.ICarroRepository;
import com.conce_carros.persistence.mapper.ICarroMapper;
import com.conce_carros.persistence.repository.crud.ICarroCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarroRepository implements ICarroRepository {

    private final ICarroCrudRepository iCarroCrudRepository;
    private final ICarroMapper iCarroMapper;


    @Override
    public List<CarroDTO> getAll() {
        return iCarroMapper.toCarrosDTO(iCarroCrudRepository.findAll());
    }

    @Override
    public List<CarroDTO> getByIdMarcaCarro(Integer marcaCarroId) {
        return iCarroMapper.toCarrosDTO(iCarroCrudRepository.findAllByMarcaCarroId(marcaCarroId));
    }

    @Override
    public List<CarroDTO> getCarrosByLessThan(Double precio) {
        return iCarroMapper.toCarrosDTO(iCarroCrudRepository.findAllByPrecioLessThanEqualOrderByPrecioAsc(precio));
    }

    @Override
    public Optional<CarroDTO> getCarro(Integer codigoCarro) {
        return iCarroCrudRepository.findById(codigoCarro)
                .map(iCarroMapper::toCarroDTO);
    }

    @Override
    public CarroDTO save(CarroDTO newCarro) {
        return iCarroMapper.toCarroDTO(iCarroCrudRepository.save(iCarroMapper.toCarroEntity(newCarro)));
    }

    @Override
    public void delete(Integer codigoCarro) {
        iCarroCrudRepository.deleteById(codigoCarro);
    }
}
