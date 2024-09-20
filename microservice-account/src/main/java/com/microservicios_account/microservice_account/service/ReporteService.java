package com.microservicios_account.microservice_account.service;

import com.microservicios_account.microservice_account.entity.Cuenta;
import com.microservicios_account.microservice_account.entity.Movimientos;
import com.microservicios_account.microservice_account.repository.CuentaRepository;
import com.microservicios_account.microservice_account.repository.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientosRepository movimientoRepository;

    public Map<String, Object> generarReporte(Long clienteId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        Map<String, Object> reporte = new HashMap<>();


        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);


        reporte.put("cuentas", cuentas);

        Map<String, List<Movimientos>> detallesMovimientos = new HashMap<>();
        for (Cuenta cuenta : cuentas) {
            List<Movimientos> movimientos = movimientoRepository.findByCuentaIdAndFechaBetween(cuenta.getId(), fechaInicio, fechaFin);
            detallesMovimientos.put(cuenta.getNumeroCuenta(), movimientos);
        }

        // Agregar los detalles de movimientos al reporte
        reporte.put("detallesMovimientos", detallesMovimientos);

        return reporte;
    }
}
