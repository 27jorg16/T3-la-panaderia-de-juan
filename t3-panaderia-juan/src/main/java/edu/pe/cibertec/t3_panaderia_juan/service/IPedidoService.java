package edu.pe.cibertec.t3_panaderia_juan.service;

import edu.pe.cibertec.t3_panaderia_juan.dto.GenericResponseDto;
import edu.pe.cibertec.t3_panaderia_juan.dto.PedidoDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IPedidoService {
    PedidoDTO obtenerPedidoPorId(Integer id);
    List<PedidoDTO> obtenerTodosLosPedidos();

    @Transactional
    GenericResponseDto registrarPedido(PedidoDTO pedidoDto);

    PedidoDTO obtenerPedido(Integer id);
}
