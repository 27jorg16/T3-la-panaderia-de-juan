package edu.pe.cibertec.t3_panaderia_juan.dto;

import lombok.Data;

@Data
public class ProveedorDTO {
    private Integer proveedorId;
    private String nombreProveedor;
    private String telefonoProveedor;
    private String correoProveedor;
    private String direccionProveedor;
}
