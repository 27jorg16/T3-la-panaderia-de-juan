package edu.pe.cibertec.t3_panaderia_juan.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PedidoDTO {
    private Integer pedidoId;
    private Integer clienteId;
    private Date fechaPedido;
    private Double totalPedido;

}
