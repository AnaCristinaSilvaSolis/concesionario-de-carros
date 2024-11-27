package com.conce_carros.domain.repository;

import com.conce_carros.domain.dto.MarcaCarroDTO;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca carro
 */
public interface IMarcaCarroRepository {
    /**
     * Devuelve una lista con todas las marcas de carros
     * @return Lista con marcas de carros
     */
    List<MarcaCarroDTO> getAll();

    /**
     * Devuelve una marca de carro, dado su id
     * @param id Id de marca carro
     * @return Optional de la marca carro encontrado
     */
    Optional<MarcaCarroDTO> getMarcaCarro(Integer id);

    /**
     * Guarda una nueva marca carro
     * @param newMarcaCarro Marca carro a guardar
     * @return Marca carro guardada
     */
    MarcaCarroDTO save(MarcaCarroDTO newMarcaCarro);

    /**
     * Elimina una marca carro dado su id
     * @param idMarcaCarro Id de la marca carro a eliminar
     */
    void delete(Integer idMarcaCarro);

}
