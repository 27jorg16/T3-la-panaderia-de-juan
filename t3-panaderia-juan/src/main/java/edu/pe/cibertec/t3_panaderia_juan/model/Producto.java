package edu.pe.cibertec.t3_panaderia_juan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;

    @Column(name = "NombreProducto")
    private String nombreProducto;

    @Column(name = "DescripcionProducto")
    private String descripcionProducto;

    @Column(name = "PrecioProducto")
    private Double precioProducto;

    @Column(name = "StockProducto")
    private Integer stockProducto;
}