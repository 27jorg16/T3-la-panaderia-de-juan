package edu.pe.cibertec.t3_panaderia_juan.service.impl;

import edu.pe.cibertec.t3_panaderia_juan.dto.GenericResponseDto;
import edu.pe.cibertec.t3_panaderia_juan.dto.PedidoDTO;
import edu.pe.cibertec.t3_panaderia_juan.exception.ResourceNotFoundException;
import edu.pe.cibertec.t3_panaderia_juan.model.Cliente;
import edu.pe.cibertec.t3_panaderia_juan.model.Pedido;
import edu.pe.cibertec.t3_panaderia_juan.repository.ClienteRepository;
import edu.pe.cibertec.t3_panaderia_juan.repository.PedidoRepository;
import edu.pe.cibertec.t3_panaderia_juan.service.IPedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PedidoService implements IPedidoService {


    private final PedidoRepository pedidoRepository;


    private final ProductoService productoService;


    private final ClienteRepository clienteRepository;

    @Override
    public PedidoDTO obtenerPedidoPorId(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        return convertirAPedidoDTO(pedido);
    }

    @Override
    public List<PedidoDTO> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll().stream()
                .map(this::convertirAPedidoDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GenericResponseDto registrarPedido(PedidoDTO pedidoDto) {
        Pedido pedido = new Pedido();

        Cliente cliente = clienteRepository.findById(pedidoDto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        pedido.setCliente(cliente);
        pedido.setTotalPedido(pedidoDto.getTotalPedido());
        pedido.setFechaPedido(new Date());
        pedidoRepository.save(pedido);

        productoService.actualizarStock(pedidoDto.getProductos());

        return new GenericResponseDto("Pedido registrado con éxito");
    }

    @Override
    public PedidoDTO obtenerPedido(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        return new PedidoDTO(pedido);
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
