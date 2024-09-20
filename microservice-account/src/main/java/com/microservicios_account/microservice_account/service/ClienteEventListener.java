package com.microservicios_account.microservice_account.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ClienteEventListener {

    @RabbitListener(queues = "cliente.creado")
    public void manejarEventoCreacionCliente(String mensaje) {
        System.out.println("Evento recibido: " + mensaje);
    }
}
