package edu.pe.cibertec.t3_panaderia_juan.service.impl;

import edu.pe.cibertec.t3_panaderia_juan.dto.PedidoDTO;
import edu.pe.cibertec.t3_panaderia_juan.model.Pedido;
import edu.pe.cibertec.t3_panaderia_juan.repository.PedidoRepository;
import edu.pe.cibertec.t3_panaderia_juan.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoDTO obtenerPedidoPorId(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        return convertirAPedidoDTO(pedido);
    }

    public List<PedidoDTO> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll().stream()
                .map(this::convertirAPedidoDTO)
                .collect(Collectors.toList());
    }

    private PedidoDTO convertirAPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setPedidoId(pedido.getPedidoId());
        pedidoDTO.setClienteId(pedido.getCliente().getClienteId());
        pedidoDTO.setFechaPedido(pedido.getFechaPedido());
        pedidoDTO.setTotalPedido(pedido.getTotalPedido());
        return pedidoDTO;
    }
}
