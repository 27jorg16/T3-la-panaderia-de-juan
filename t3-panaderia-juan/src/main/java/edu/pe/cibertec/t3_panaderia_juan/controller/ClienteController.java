package edu.pe.cibertec.t3_panaderia_juan.controller;

import edu.pe.cibertec.t3_panaderia_juan.dto.ClienteDTO;
import edu.pe.cibertec.t3_panaderia_juan.service.impl.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Integer id) {
        ClienteDTO clienteDTO = clienteService.obtenerClientePorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

}