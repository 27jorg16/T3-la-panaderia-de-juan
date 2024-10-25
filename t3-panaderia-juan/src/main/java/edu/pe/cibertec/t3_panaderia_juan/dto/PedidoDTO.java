package edu.pe.cibertec.t3_panaderia_juan.dto;

import edu.pe.cibertec.t3_panaderia_juan.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
public class PedidoDTO {
    private Integer pedidoId;
    private Integer clienteId;
    private Date fechaPedido;
    private Double totalPedido;
    private List<ProductoDTO> productos;


    public PedidoDTO(Pedido pedido) {
        this.pedidoId = pedido.getPedidoId();
        this.clienteId = pedido.getCliente().getClienteId();
        this.fechaPedido = pedido.getFechaPedido();
        this.totalPedido = pedido.getTotalPedido();
    }
}
