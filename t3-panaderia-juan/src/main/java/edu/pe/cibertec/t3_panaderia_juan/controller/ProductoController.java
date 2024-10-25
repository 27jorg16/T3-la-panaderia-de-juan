package edu.pe.cibertec.t3_panaderia_juan.controller;

import edu.pe.cibertec.t3_panaderia_juan.dto.ProductoDTO;
import edu.pe.cibertec.t3_panaderia_juan.service.impl.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable Integer id) {
        ProductoDTO productoDTO = productoService.obtenerProductoPorId(id);
        return ResponseEntity.ok(productoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodosLosProductos() {
        List<ProductoDTO> productos = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }
    @PutMapping("/actualizar-stock")
    public ResponseEntity<Void> actualizarStock(@RequestBody List<ProductoDTO> productos) {
        productoService.actualizarStock(productos);
        return ResponseEntity.ok().build(); // Retornar una respuesta 200 OK si todo fue exitoso
    }
}