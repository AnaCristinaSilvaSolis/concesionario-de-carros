package com.conce_carros.persistence.repository.impl;

import com.conce_carros.domain.dto.ClienteDTO;
import com.conce_carros.domain.repository.IClienteRepository;
import com.conce_carros.persistence.mapper.IClienteMapper;
import com.conce_carros.persistence.repository.IClienteCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de cliente
 */

@RequiredArgsConstructor
@Repository
public class ClienteRepository implements IClienteRepository {

    private final IClienteCrudRepository iClienteCrudRepository;
    private final IClienteMapper iClienteMapper;

    /**
     * Devuelve una lista con todos los clientes
     *
     * @return Lista con todos los clientes
     */
    @Override
    public List<ClienteDTO> getAll() {
        return iClienteMapper.toClientesDTO(iClienteCrudRepository.findAll());
    }

    /**
     * Devuelve un cliente, dado su cedula
     *
     * @param cedula Cedula de cliente
     * @return Optional de cliente encontrado
     */
    @Override
    public Optional<ClienteDTO> getClienteByCedula(String cedula) {
        return iClienteCrudRepository.findById(cedula)
                .map(iClienteMapper::toClienteDTO);
    }

    @Override
    public Optional<ClienteDTO> getClienteByCorreo(String correo) {
        return iClienteCrudRepository.findByCorreo(correo)
                .map(iClienteMapper::toClienteDTO);
    }

    /**
     * Guarda un nuevo cliente
     *
     * @param newClienteDTO cliente a guardar
     * @return cliente guardado
     */
    @Override
    public ClienteDTO save(ClienteDTO newClienteDTO) {
        return iClienteMapper.toClienteDTO(iClienteCrudRepository.save(iClienteMapper.toClienteEntity(newClienteDTO)));
    }

    /**
     * Elimina un cliente dado su id
     *
     * @param cedula Cedula de cliente a eliminar
     */
    @Override
    public void delete(String cedula) {
        iClienteCrudRepository.deleteById(cedula);
    }
}
