package edu.pe.cibertec.t3_panaderia_juan.service.impl;

import edu.pe.cibertec.t3_panaderia_juan.dto.ClienteDTO;
import edu.pe.cibertec.t3_panaderia_juan.model.Cliente;
import edu.pe.cibertec.t3_panaderia_juan.repository.ClienteRepository;
import edu.pe.cibertec.t3_panaderia_juan.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {


    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDTO obtenerClientePorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return convertirAClienteDTO(cliente);
    }

    @Override
    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteRepository.findAll().stream()
                .map(this::convertirAClienteDTO)
                .collect(Collectors.toList());
    }

    private ClienteDTO convertirAClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setClienteId(cliente.getClienteId());
        clienteDTO.setNombreCliente(cliente.getNombreCliente());
        clienteDTO.setCorreoCliente(cliente.getCorreoCliente());
        clienteDTO.setTelefonoCliente(cliente.getTelefonoCliente());
        clienteDTO.setDireccionCliente(cliente.getDireccionCliente());
        return clienteDTO;
    }
}