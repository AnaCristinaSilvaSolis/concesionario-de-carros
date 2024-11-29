package com.conce_carros.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de Carro Compra
 */
@Getter
@Setter
@Entity
@Table(name = "carros_compras")
public class CarroCompraEntity {

    @EmbeddedId
    private CarroCompraPrimaryKey id;

    private Integer cantidad;
    private Integer total;

    @ManyToOne
    @MapsId(value = "comprasNumerofactura")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private CompraEntity compraEntity;

    @ManyToOne
    @JoinColumn(name = "carros_codigo_carros", insertable = false, updatable = false)
    private CarroEntity carroEntity;
}
