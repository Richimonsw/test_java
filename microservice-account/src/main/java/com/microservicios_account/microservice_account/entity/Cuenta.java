package com.microservicios_account.microservice_account.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroCuenta;

    private String tipoCuenta;
    private double saldoInicial;
    private Boolean estado;

    private Long clienteId;
}
