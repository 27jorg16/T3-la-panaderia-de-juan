package edu.pe.cibertec.t3_panaderia_juan.service;

import edu.pe.cibertec.t3_panaderia_juan.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    ProductoDTO obtenerProductoPorId(Integer id);
    List<ProductoDTO> obtenerTodosLosProductos();
}
