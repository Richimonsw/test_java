package com.microservicios_account.microservice_account.service;

import com.microservicios_account.microservice_account.entity.Movimientos;

public interface MovimientoService {
    Movimientos registrarMovimiento(Long cuentaId, Movimientos movimiento);
}
