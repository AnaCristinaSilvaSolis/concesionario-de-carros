package com.conce_carros.domain.service.useCase;

import com.conce_carros.domain.dto.ClienteDTO;
import com.conce_carros.domain.dto.ResponseClienteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interface de servicio de Cliente
 */
public interface IClienteUseCase {

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
    ResponseClienteDTO save(ClienteDTO newClienteDTO);

    /**
     * Actualiza un cliente
     * @param clienteDTOUpdate cliente a actualizar
     * @return Cliente actualizado
     */
    Optional<ClienteDTO> update(ClienteDTO clienteDTOUpdate);

    /**
     * Elimina un cliente dado su id
     * @param cedula Cedula de cliente a eliminar
     */
    boolean delete(String cedula);
}
