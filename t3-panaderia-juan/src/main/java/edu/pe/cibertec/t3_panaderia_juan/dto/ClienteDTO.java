package edu.pe.cibertec.t3_panaderia_juan.dto;

import edu.pe.cibertec.t3_panaderia_juan.model.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {
    private Integer clienteId;
    private String nombreCliente;
    private String correoCliente;
    private String telefonoCliente;
    private String direccionCliente;

}
