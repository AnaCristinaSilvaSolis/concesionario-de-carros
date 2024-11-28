package com.conce_carros.persistence.repository.crud;

import com.conce_carros.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteCrudRepository extends JpaRepository<ClienteEntity, String> {

    Optional<ClienteEntity> findByCorreo(String correo);
}
