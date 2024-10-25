package edu.pe.cibertec.t3_panaderia_juan.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Integer productoId;
    private String nombreProducto;
    private String descripcionProducto;
    private Double precioProducto;
    private Integer stockProducto;
}
