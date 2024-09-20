package com.microservicios_account.microservice_account.controller;

import com.microservicios_account.microservice_account.entity.Cuenta;
import com.microservicios_account.microservice_account.service.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;


    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestParam Long clienteId, @RequestBody Cuenta cuenta) {

        Cuenta nuevaCuenta = cuentaService.crearCuenta(clienteId, cuenta);
        return ResponseEntity.ok(nuevaCuenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.obtenerCuenta(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return ResponseEntity.ok(cuentaService.actualizarCuenta(id, cuenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }
}
