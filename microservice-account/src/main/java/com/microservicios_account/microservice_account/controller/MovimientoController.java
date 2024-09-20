package com.microservicios_account.microservice_account.controller;

import com.microservicios_account.microservice_account.entity.Movimientos;
import com.microservicios_account.microservice_account.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/{cuentaId}")
    public ResponseEntity<Movimientos> registrarMovimiento(@PathVariable Long cuentaId, @RequestBody Movimientos movimiento) {
        return ResponseEntity.ok(movimientoService.registrarMovimiento(cuentaId, movimiento));
    }
}
