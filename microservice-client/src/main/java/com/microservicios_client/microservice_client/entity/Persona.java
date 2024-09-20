package com.microservicios_client.microservice_client.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String genero;
    private int edad;

    @Column(unique = true)
    private String identificacion;
    private String direccion;

    @Column(unique = true)
    private String telefono;

}
