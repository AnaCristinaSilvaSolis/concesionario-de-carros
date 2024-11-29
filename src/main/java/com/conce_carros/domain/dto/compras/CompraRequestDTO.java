package com.conce_carros.domain.dto.compras;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO del guardado de una compra
 */
public class CompraRequestDTO {

    private Integer numeroFactura;
    private String cedulaCliente;
    private LocalDateTime fechaCompra;
    private Double totalCompra;
    private String medioPago;

    private List<CarroCompraRequestDTO> carrosCompra;
}
