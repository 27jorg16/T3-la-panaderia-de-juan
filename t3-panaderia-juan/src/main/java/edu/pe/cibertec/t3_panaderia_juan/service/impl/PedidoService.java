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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private  PedidoRepository pedidoRepository;

    @Autowired
    private  ProductoService productoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public PedidoDTO obtenerPedidoPorId(Integer id) {
        return null;
    }

    @Override
    public List<PedidoDTO> obtenerTodosLosPedidos() {
        return List.of();
    }

    @Override
    @Transactional
    public GenericResponseDto registrarPedido(PedidoDTO pedidoDto) {
        // Lógica para registrar el pedido y actualizar el stock de productos
        Pedido pedido = new Pedido();

        // Obtener el cliente usando el clienteId desde el DTO
        Cliente cliente = clienteRepository.findById(pedidoDto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        // Asignar el cliente al pedido
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
}
