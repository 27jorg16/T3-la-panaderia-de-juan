package edu.pe.cibertec.t3_panaderia_juan.service;

import edu.pe.cibertec.t3_panaderia_juan.dto.ProveedorDTO;

import java.util.List;

public interface IProveedorService {
    ProveedorDTO obtenerProveedorPorId(Integer id);
    List<ProveedorDTO> obtenerTodosLosProveedores();
}
