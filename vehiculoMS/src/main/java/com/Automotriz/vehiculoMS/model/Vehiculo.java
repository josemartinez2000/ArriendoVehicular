package com.Automotriz.vehiculoMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Integer anio;

    // "DISPONIBLE", "ARRENDADO", "EN_MANTENCION"
    @Column(nullable = false)
    private String estado;

    @Column(nullable = false, unique = true)
    private String patente;
}
