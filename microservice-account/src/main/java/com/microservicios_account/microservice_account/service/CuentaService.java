package com.microservicios_account.microservice_account.service;

import com.microservicios_account.microservice_account.entity.Cuenta;

public interface CuentaService {
    Cuenta crearCuenta(Long clienteId, Cuenta cuenta);
    Cuenta obtenerCuenta(Long id);
    Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada);
    void eliminarCuenta(Long id);
}
