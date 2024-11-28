package com.conce_carros.persistence.repository.crud;

import com.conce_carros.persistence.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarroCrudRepository extends JpaRepository<CarroEntity, Integer> {

    List<CarroEntity> findAllByMarcaCarroId(Integer marcaCarroId);

    List<CarroEntity> findAllByPrecioLessThanEqualOrderByPrecioAsc(Double precio);
}
