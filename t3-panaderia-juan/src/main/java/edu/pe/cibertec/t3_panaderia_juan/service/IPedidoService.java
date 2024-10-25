package edu.pe.cibertec.t3_panaderia_juan.service;

import edu.pe.cibertec.t3_panaderia_juan.dto.PedidoDTO;

import java.util.List;

public interface IPedidoService {
    PedidoDTO obtenerPedidoPorId(Integer id);
    List<PedidoDTO> obtenerTodosLosPedidos();
}
