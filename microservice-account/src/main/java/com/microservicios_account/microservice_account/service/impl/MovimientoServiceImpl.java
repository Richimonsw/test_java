package com.microservicios_account.microservice_account.service.impl;

import com.microservicios_account.microservice_account.entity.Cuenta;
import com.microservicios_account.microservice_account.entity.Movimientos;
import com.microservicios_account.microservice_account.exception.ResourceNotFoundException;
import com.microservicios_account.microservice_account.exception.SaldoInsuficienteException;
import com.microservicios_account.microservice_account.repository.CuentaRepository;
import com.microservicios_account.microservice_account.repository.MovimientosRepository;
import com.microservicios_account.microservice_account.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Movimientos registrarMovimiento(Long cuentaId, Movimientos movimiento) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + cuentaId));

        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();

        if (nuevoSaldo < 0) {
            throw new SaldoInsuficienteException("Saldo no disponible");
        }

        movimiento.setCuenta(cuenta);
        movimiento.setSaldo(nuevoSaldo);
        movimiento.setFecha(LocalDateTime.now());

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        return movimientosRepository.save(movimiento);


    }
}
