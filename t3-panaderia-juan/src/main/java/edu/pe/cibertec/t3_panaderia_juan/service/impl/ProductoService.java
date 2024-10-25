package edu.pe.cibertec.t3_panaderia_juan.service.impl;

import edu.pe.cibertec.t3_panaderia_juan.dto.ProductoDTO;
import edu.pe.cibertec.t3_panaderia_juan.exception.ResourceNotFoundException;
import edu.pe.cibertec.t3_panaderia_juan.model.Producto;
import edu.pe.cibertec.t3_panaderia_juan.repository.ProductoRepository;
import edu.pe.cibertec.t3_panaderia_juan.service.IProductoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService {


    private final ProductoRepository productoRepository;

    public ProductoDTO obtenerProductoPorId(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return convertirAProductoDTO(producto);
    }

    public List<ProductoDTO> obtenerTodosLosProductos() {
        return productoRepository.findAll().stream()
                .map(this::convertirAProductoDTO)
                .collect(Collectors.toList());
    }

    private ProductoDTO convertirAProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setProductoId(producto.getProductoId());
        productoDTO.setNombreProducto(producto.getNombreProducto());
        productoDTO.setDescripcionProducto(producto.getDescripcionProducto());
        productoDTO.setPrecioProducto(producto.getPrecioProducto());
        productoDTO.setStockProducto(producto.getStockProducto());
        return productoDTO;
    }

    @Transactional
    public void actualizarStock(List<ProductoDTO> productos) {
        for (ProductoDTO productoDTO : productos) {
            Producto producto = productoRepository.findById(productoDTO.getProductoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + productoDTO.getProductoId()));

            producto.setStockProducto(producto.getStockProducto() - productoDTO.getStockProducto());

            productoRepository.save(producto);
        }
    }
}
