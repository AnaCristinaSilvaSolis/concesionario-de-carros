package com.conce_carros.persistence.repository.impl;

import com.conce_carros.domain.dto.MarcaCarroDTO;
import com.conce_carros.domain.repository.IMarcaCarroRepository;
import com.conce_carros.persistence.entity.MarcaCarroEntity;
import com.conce_carros.persistence.mapper.IMarcaCarroMapper;
import com.conce_carros.persistence.repository.IMarcaCarroCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca carro
 */
@RequiredArgsConstructor
@Repository
public class MarcaCarroRepository implements IMarcaCarroRepository {

    /**
     * Crud de marca carro
     */
    private final IMarcaCarroCrudRepository iMarcaCarroCrudRepository;

    /**
     * Mapper de marca carro
     */
    private final IMarcaCarroMapper iMarcaCarroMapper;

    /**
     * Devuelve una lista con todas las marcas de carros
     * @return Lista con las marcas de carros
     */
    @Override
    public List<MarcaCarroDTO> getAll() {
        return iMarcaCarroMapper.toMarcasCarroDTO(iMarcaCarroCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de carro dado su id
     * @param id Id de marca carro
     * @return Optional de la marca carro encontrado
     */
    @Override
    public Optional<MarcaCarroDTO> getMarcaCarro(Integer id) {
        return iMarcaCarroCrudRepository.findById(id)
                .map(iMarcaCarroMapper::toMarcaCarroDTO);
    }

    /**
     * Guarda una nueva marca carro
     * @param newMarcaCarro Marca carro a guardar
     * @return Marca carro guardada
     */
    @Override
    public MarcaCarroDTO save(MarcaCarroDTO newMarcaCarro) {
        MarcaCarroEntity marcaCarroEntity = iMarcaCarroMapper.toMarcaCarroEntity(newMarcaCarro);
        return iMarcaCarroMapper.toMarcaCarroDTO(iMarcaCarroCrudRepository.save(marcaCarroEntity));
    }

    /**
     * Elimina una marca carro dado su id
     * @param idMarcaCarro Id de la marca carro a eliminar
     */
    @Override
    public void delete(Integer idMarcaCarro) {
        iMarcaCarroCrudRepository.deleteById(idMarcaCarro);
    }
}
