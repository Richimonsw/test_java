package com.microservicios_client.microservice_client.clientes;

import com.microservicios_client.microservice_client.entity.Cliente;
import com.microservicios_client.microservice_client.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testCrearCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Pérez");
        cliente.setContraseña("1234");
        cliente.setEstado(true);

        Cliente clienteGuardado = clienteRepository.save(cliente);

        assertNotNull(clienteGuardado);
        assertEquals("Juan Pérez", clienteGuardado.getNombre());
    }
}
