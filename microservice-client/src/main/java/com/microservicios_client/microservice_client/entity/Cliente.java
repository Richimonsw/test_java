package com.microservicios_client.microservice_client.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cliente extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contraseña;
    private Boolean estado;


}
