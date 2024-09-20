package com.microservicios_client.microservice_client.repository;

import com.microservicios_client.microservice_client.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
