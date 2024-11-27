package com.conce_carros.domain.service.impl;

import com.conce_carros.domain.dto.ClienteDTO;
import com.conce_carros.domain.dto.ResponseClienteDTO;
import com.conce_carros.domain.repository.IClienteRepository;
import com.conce_carros.domain.service.IClienteService;
import com.conce_carros.exception.CorreoValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de cliente
 */
@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final IClienteRepository iClienteRepository;

    /**
     * Devuelve una lista con todos los clientes
     *
     * @return Lista con todos los clientes
     */
    @Override
    public List<ClienteDTO> getAll() {
        return iClienteRepository.getAll();
    }

    /**
     * Devuelve un cliente, dado su cedula
     *
     * @param cedula Cedula de cliente
     * @return Optional de cliente encontrado
     */
    @Override
    public Optional<ClienteDTO> getClienteByCedula(String cedula) {
        return iClienteRepository.getClienteByCedula(cedula);
    }

    /**
     * Devuelve un cliente, dado su correo
     *
     * @param correo Correo de cliente
     * @return Optional de cliente encontrado
     */
    @Override
    public Optional<ClienteDTO> getClienteByCorreo(String correo) {
        return iClienteRepository.getClienteByCorreo(correo);
    }

    /**
     * Guarda un nuevo cliente
     *
     * @param newCliente cliente a guardar
     * @return cliente guardado
     */
    @Override
    public ResponseClienteDTO save(ClienteDTO newCliente) {

        if (!newCliente.getCorreo().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new CorreoValidationException();
        }

        String contraseniaGenerated = generateRandomPassword(8);
        newCliente.setContrasenia(contraseniaGenerated);
        newCliente.setActivo(1);
        iClienteRepository.save(newCliente);

        return new ResponseClienteDTO(contraseniaGenerated);
    }

    @Override
    public Optional<ClienteDTO> update(ClienteDTO clienteDTOUpdate) {
        if (iClienteRepository.getClienteByCedula(clienteDTOUpdate.getCedula()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iClienteRepository.save(clienteDTOUpdate));
    }

    /**
     * Elimina un cliente dado su id
     *
     * @param cedula Cedula de cliente a eliminar
     */
    @Override
    public boolean delete(String cedula) {
        if (iClienteRepository.getClienteByCedula(cedula).isEmpty()) {
            return false;
        }
        iClienteRepository.delete(cedula);
        return true;
    }

    /**
     * Método para generar una contraseña alfanumérica aleatoria de una longitud específica
     */
    private String generateRandomPassword(int len) {
        /**
         * Rango ASCII - alfanumérico (0-9, a-z, A-Z)
         */
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        /**
         * Cada iteración del bucle elige aleatoriamente un carácter del dado.
         * Rango ASCII y lo agrega a la instancia `StringBuilder`
         */
        for (int i = 0; i <= len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
