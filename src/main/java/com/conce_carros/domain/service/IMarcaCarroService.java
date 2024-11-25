package com.conce_carros.domain.service;

import com.conce_carros.domain.pojo.MarcaCarroPojo;

import java.util.List;
import java.util.Optional;

public interface IMarcaCarroService {
    /**
     * Devuelve una lista con todas las marcas de carros
     * @return Lista con marcas de carros
     */
    List<MarcaCarroPojo> getAll();

    /**
     * Devuelve una marca de carro, dado su id
     * @param id Id de marca carro
     * @return Optional de la marca carro encontrado
     */
    Optional<MarcaCarroPojo> getMarcaCarro(Integer id);

    /**
     * Guarda una nueva marca carro
     * @param newMarcaCarro Marca carro a guardar
     * @return Marca carro guardada
     */
    MarcaCarroPojo save(MarcaCarroPojo newMarcaCarro);

    /**
     * Actualiza una marca carro
     * @param marcaCarroPojoUpdate Marca carro a actualizar
     * @return Marca carro actualizada
     */
    Optional<MarcaCarroPojo> update(MarcaCarroPojo marcaCarroPojoUpdate);

    /**
     * Elimina una marca carro dado su id
     * @param idMarcaCarro Id de la marca carro a eliminar
     * @return true si se eliminó y false de lo contrario
     */
    boolean delete(Integer idMarcaCarro);
}
