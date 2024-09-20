package com.microservicios_client.microservice_client.service;

import com.microservicios_client.microservice_client.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente createCliente(Cliente cliente);
    Cliente obtenerCliente(Long id);
    List<Cliente> obtenerClientes();
    Cliente actualizarCliente(Long id, Cliente clienteActualizado);
    void eliminarCliente(Long id);

}
