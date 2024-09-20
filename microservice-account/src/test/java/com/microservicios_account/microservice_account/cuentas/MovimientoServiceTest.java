package com.microservicios_account.microservice_account.cuentas;
import com.microservicios_account.microservice_account.entity.Cuenta;
import com.microservicios_account.microservice_account.entity.Movimientos;
import com.microservicios_account.microservice_account.repository.CuentaRepository;
import com.microservicios_account.microservice_account.service.MovimientoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MovimientoServiceTest {

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Test
    public void testRegistrarMovimiento() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456");
        cuenta.setTipoCuenta("Ahorro");
        cuenta.setSaldoInicial(1000);
        cuenta.setEstado(true);
        cuentaRepository.save(cuenta);

        Movimientos movimiento = new Movimientos();
        movimiento.setValor(500);
        movimiento.setTipoMovimiento("Depósito");
        movimiento.setFecha(LocalDateTime.now());

        Movimientos movimientoRegistrado = movimientoService.registrarMovimiento(cuenta.getId(), movimiento);

        assertNotNull(movimientoRegistrado);
        assertEquals(1500, cuentaRepository.findById(cuenta.getId()).get().getSaldoInicial());
    }
}
