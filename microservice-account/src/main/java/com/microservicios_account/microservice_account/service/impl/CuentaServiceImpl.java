package com.microservicios_account.microservice_account.service.impl;

import com.microservicios_account.microservice_account.dto.ClienteDTO;
import com.microservicios_account.microservice_account.entity.Cuenta;
import com.microservicios_account.microservice_account.exception.ResourceNotFoundException;
import com.microservicios_account.microservice_account.repository.CuentaRepository;
import com.microservicios_account.microservice_account.repository.MovimientosRepository;
import com.microservicios_account.microservice_account.service.ClienteService;
import com.microservicios_account.microservice_account.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public Cuenta crearCuenta(Long clienteId, Cuenta cuenta) {

        ClienteDTO cliente = clienteService.obtenerClientePorId(clienteId);

        cuenta.setClienteId(clienteId);

        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta obtenerCuenta(Long id) {
        return cuentaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    @Override
    public Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada) {
        Cuenta cuenta = obtenerCuenta(id);
        cuenta.setTipoCuenta(cuentaActualizada.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaActualizada.getSaldoInicial());
        cuenta.setEstado(cuentaActualizada.getEstado());
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Long cuentaId) {
        // Buscar la cuenta
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con ID: " + cuentaId));

        // Eliminar todos los movimientos asociados a la cuenta
        movimientosRepository.deleteByCuentaId(cuentaId);

        // Eliminar la cuenta
        cuentaRepository.delete(cuenta);
    }

}
