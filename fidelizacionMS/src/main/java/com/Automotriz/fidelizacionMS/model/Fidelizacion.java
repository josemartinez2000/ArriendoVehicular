package com.Automotriz.fidelizacionMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fidelizacion")
public class Fidelizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // RUT del cliente en usuarioMS
    @Column(nullable = false, unique = true)
    private String rutCliente;

    @Column(nullable = false)
    private Integer puntosAcumulados;

    // "BRONCE", "PLATA", "ORO", "PLATINO"
    @Column(nullable = false)
    private String nivelSocio;
}
