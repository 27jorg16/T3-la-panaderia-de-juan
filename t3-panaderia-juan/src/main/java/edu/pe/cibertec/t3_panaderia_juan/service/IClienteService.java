package edu.pe.cibertec.t3_panaderia_juan.service;

import edu.pe.cibertec.t3_panaderia_juan.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {
    ClienteDTO obtenerClientePorId(Integer id);
    List<ClienteDTO> obtenerTodosLosClientes();
}
