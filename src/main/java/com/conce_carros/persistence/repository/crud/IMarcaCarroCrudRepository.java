package com.conce_carros.persistence.repository.crud;

import com.conce_carros.persistence.entity.MarcaCarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaCarroCrudRepository extends JpaRepository<MarcaCarroEntity, Integer> {

}