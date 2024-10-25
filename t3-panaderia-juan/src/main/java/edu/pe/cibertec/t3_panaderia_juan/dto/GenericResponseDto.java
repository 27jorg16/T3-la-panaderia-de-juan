package edu.pe.cibertec.t3_panaderia_juan.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericResponseDto {
    private String mensaje;
    private HttpStatus status;

    public GenericResponseDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public GenericResponseDto(String mensaje, HttpStatus status) {
        this.mensaje = mensaje;
        this.status = status;
    }


}