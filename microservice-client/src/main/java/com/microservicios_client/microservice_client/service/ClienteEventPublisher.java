package com.microservicios_client.microservice_client.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarEventoCreacionCliente(String mensaje) {
        rabbitTemplate.convertAndSend("clientes-exchange", "cliente.creado", mensaje);
    }
}
