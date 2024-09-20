package com.microservicios_account.microservice_account.repository;

import com.microservicios_account.microservice_account.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByClienteId(Long clienteId);
}
