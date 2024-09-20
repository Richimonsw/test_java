package com.microservicios_client.microservice_client.service.impl;

import com.microservicios_client.microservice_client.entity.Cliente;
import com.microservicios_client.microservice_client.exception.ResourceNotFoundException;
import com.microservicios_client.microservice_client.repository.ClienteRepository;
import com.microservicios_client.microservice_client.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente cliente = obtenerCliente(id);
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setContraseña(clienteActualizado.getContraseña());
        cliente.setEstado(clienteActualizado.getEstado());
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        Cliente cliente = obtenerCliente(id);
        clienteRepository.delete(cliente);
    }
}
