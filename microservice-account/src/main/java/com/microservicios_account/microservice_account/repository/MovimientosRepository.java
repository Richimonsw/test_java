package com.microservicios_account.microservice_account.repository;

import com.microservicios_account.microservice_account.entity.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientosRepository  extends JpaRepository<Movimientos, Long> {
    List<Movimientos> findByCuentaIdAndFechaBetween(Long cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
    void deleteByCuentaId(Long cuentaId);
}
