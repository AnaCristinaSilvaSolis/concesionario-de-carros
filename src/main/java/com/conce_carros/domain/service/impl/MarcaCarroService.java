package com.conce_carros.domain.service.impl;

import com.conce_carros.domain.pojo.MarcaCarroPojo;
import com.conce_carros.domain.repository.IMarcaCarroRepository;
import com.conce_carros.domain.service.IMarcaCarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca carro
 */
@RequiredArgsConstructor
@Service
public class MarcaCarroService implements IMarcaCarroService {
    /**
     * Repositorio de marca carro
     */
    private final IMarcaCarroRepository iMarcaCarroRepository;

    /**
     * Devuelve una lista con todas las marcas de carros
     * @return Lista con marcas de carros
     */
    @Override
    public List<MarcaCarroPojo> getAll() {
        return iMarcaCarroRepository.getAll();
    }

    /**
     * Devuelve una marca de carro, dado su id
     * @param id Id de marca carro
     * @return Optional de la marca carro encontrado
     */
    @Override
    public Optional<MarcaCarroPojo> getMarcaCarro(Integer id) {
        return iMarcaCarroRepository.getMarcaCarro(id);
    }


    /**
     * Guarda una nueva marca carro
     * @param newMarcaCarro Marca carro a guardar
     * @return Marca carro guardada
     */
    @Override
    public MarcaCarroPojo save(MarcaCarroPojo newMarcaCarro) {
        return iMarcaCarroRepository.save(newMarcaCarro);
    }

    /**
     * Actualiza una marca de carro
     * @param marcaCarroPojoUpdate Marca carro a actualizar
     * @return Optional con marca de carro actualizada
     */
    @Override
    public Optional<MarcaCarroPojo> update(MarcaCarroPojo marcaCarroPojoUpdate) {
        if(iMarcaCarroRepository.getMarcaCarro(marcaCarroPojoUpdate.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iMarcaCarroRepository.save(marcaCarroPojoUpdate));
    }


    /**
     * Elimina una marca carro dado su id
     * @param idMarcaCarro Id de la marca carro a eliminar
     * @return true si se eliminó y false de lo contrario
     */
    @Override
    public boolean delete(Integer idMarcaCarro) {

        if(iMarcaCarroRepository.getMarcaCarro(idMarcaCarro).isEmpty()){
            return false;
        }
        iMarcaCarroRepository.delete(idMarcaCarro);
        return true;
    }
}
