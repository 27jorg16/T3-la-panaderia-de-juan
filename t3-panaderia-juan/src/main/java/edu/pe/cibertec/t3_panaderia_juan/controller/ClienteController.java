package edu.pe.cibertec.t3_panaderia_juan.controller;

import edu.pe.cibertec.t3_panaderia_juan.dto.ClienteDTO;
import edu.pe.cibertec.t3_panaderia_juan.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Integer id) {
        ClienteDTO clienteDTO = clienteService.obtenerClientePorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

}