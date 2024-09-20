package com.microservicios_account.microservice_account.service;

import com.microservicios_account.microservice_account.dto.ClienteDTO;
import com.microservicios_account.microservice_account.exception.ClienteNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ClienteDTO obtenerClientePorId(Long clienteId) {
        try {
            String url = "http://localhost:8081/api/clientes/" + clienteId;
            return restTemplate.getForObject(url, ClienteDTO.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ClienteNotFoundException("Cliente no encontrado con ID: " + clienteId);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el cliente desde el microservicio de clientes", e);
        }
    }
}