package com.conce_carros.persistence.entity;

import com.conce_carros.domain.dto.compras.CarroCompraRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad de Compra
 */
@Getter
@Setter
@Entity
@Table(name = "compras")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer numeroFactura;

    @Column(name = "cliente_cedula")
    private String cedulaCliente;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaCompra;

    @Column(name = "total")
    private Double totalCompra;

    @Column(name = "medio_pago")
    private String medioPago;

    @OneToMany(mappedBy = "compraEntity", cascade = {CascadeType.ALL})
    private List<CarroCompraEntity> carroCompraRequestDTO;

    @ManyToOne()
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private ClienteEntity clienteEntity;
}
