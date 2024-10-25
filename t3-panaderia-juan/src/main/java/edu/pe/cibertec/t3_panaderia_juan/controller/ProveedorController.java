package edu.pe.cibertec.t3_panaderia_juan.controller;

import edu.pe.cibertec.t3_panaderia_juan.dto.ProveedorDTO;
import edu.pe.cibertec.t3_panaderia_juan.service.impl.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> obtenerProveedor(@PathVariable Integer id) {
        ProveedorDTO proveedorDTO = proveedorService.obtenerProveedorPorId(id);
        return ResponseEntity.ok(proveedorDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> obtenerTodosLosProveedores() {
        List<ProveedorDTO> proveedores = proveedorService.obtenerTodosLosProveedores();
        return ResponseEntity.ok(proveedores);
    }

}
