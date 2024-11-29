package com.conce_carros.domain.dto.compras;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de la consulta de una compra
 */
public class CompraResponseDTO {

    private Integer numeroFactura;
    private String cedulaCliente;
    private LocalDateTime fechaCompra;
    private Double totalCompra;
    private String medioPago;

    private List<CarroCompraResponseDTO> carrosCompra;
}
