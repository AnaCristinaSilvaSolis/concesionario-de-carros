package com.conce_carros.domain.service;

import com.conce_carros.domain.dto.MarcaCarroDTO;
import com.conce_carros.domain.repository.IMarcaCarroRepository;
import com.conce_carros.domain.service.useCase.IMarcaCarroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca carro
 */
@RequiredArgsConstructor
@Service
public class MarcaCarroService implements IMarcaCarroUseCase {
    /**
     * Repositorio de marca carro
     */
    private final IMarcaCarroRepository iMarcaCarroRepository;

    /**
     * Devuelve una lista con todas las marcas de carros
     * @return Lista con marcas de carros
     */
    @Override
    public List<MarcaCarroDTO> getAll() {
        return iMarcaCarroRepository.getAll();
    }

    /**
     * Devuelve una marca de carro, dado su id
     * @param id Id de marca carro
     * @return Optional de la marca carro encontrado
     */
    @Override
    public Optional<MarcaCarroDTO> getMarcaCarro(Integer id) {
        return iMarcaCarroRepository.getMarcaCarro(id);
    }


    /**
     * Guarda una nueva marca carro
     * @param newMarcaCarro Marca carro a guardar
     * @return Marca carro guardada
     */
    @Override
    public MarcaCarroDTO save(MarcaCarroDTO newMarcaCarro) {
        return iMarcaCarroRepository.save(newMarcaCarro);
    }

    /**
     * Actualiza una marca de carro
     * @param marcaCarroDTOUpdate Marca carro a actualizar
     * @return Optional con marca de carro actualizada
     */
    @Override
    public Optional<MarcaCarroDTO> update(MarcaCarroDTO marcaCarroDTOUpdate) {
        if(iMarcaCarroRepository.getMarcaCarro(marcaCarroDTOUpdate.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iMarcaCarroRepository.save(marcaCarroDTOUpdate));
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
