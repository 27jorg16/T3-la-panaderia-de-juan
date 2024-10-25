package edu.pe.cibertec.t3_panaderia_juan.service.impl;


import edu.pe.cibertec.t3_panaderia_juan.dto.ProveedorDTO;
import edu.pe.cibertec.t3_panaderia_juan.model.Proveedor;
import edu.pe.cibertec.t3_panaderia_juan.repository.ProveedorRepository;
import edu.pe.cibertec.t3_panaderia_juan.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public ProveedorDTO obtenerProveedorPorId(Integer id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        return convertirAProveedorDTO(proveedor);
    }

    public List<ProveedorDTO> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll().stream()
                .map(this::convertirAProveedorDTO)
                .collect(Collectors.toList());
    }

    private ProveedorDTO convertirAProveedorDTO(Proveedor proveedor) {
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setProveedorId(proveedor.getProveedorId());
        proveedorDTO.setNombreProveedor(proveedor.getNombreProveedor());
        proveedorDTO.setTelefonoProveedor(proveedor.getTelefonoProveedor());
        proveedorDTO.setCorreoProveedor(proveedor.getCorreoProveedor());
        proveedorDTO.setDireccionProveedor(proveedor.getDireccionProveedor());
        return proveedorDTO;
    }
}

