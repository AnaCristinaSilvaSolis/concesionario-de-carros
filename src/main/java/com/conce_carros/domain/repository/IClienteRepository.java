package com.conce_carros.domain.repository;

import com.conce_carros.domain.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de cliente
 */
public interface IClienteRepository {
    /**
     * Devuelve una lista con todos los clientes
     * @return Lista con todos los clientes
     */
    List<ClienteDTO> getAll();

    /**
     * Devuelve un cliente, dado su cedula
     * @param cedula Cedula de cliente
     * @return Optional de cliente encontrado
     */
    Optional<ClienteDTO> getClienteByCedula(String cedula);

    /**
     * Devuelve un cliente, dado su correo
     * @param correo Correo de cliente
     * @return Optional de cliente encontrado
     */
    Optional<ClienteDTO> getClienteByCorreo(String correo);

    /**
     * Guarda un nuevo cliente
     * @param newClienteDTO cliente a guardar
     * @return cliente guardado
     */
    ClienteDTO save(ClienteDTO newClienteDTO);

    /**
     * Elimina un cliente dado su id
     * @param cedula Cedula de cliente a eliminar
     */
    void delete(String cedula);
}
