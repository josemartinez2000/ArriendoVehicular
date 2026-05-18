package com.Automotriz.reservasMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String rutCliente;

    @Column(nullable = false)
    private String patente;

    @Column(nullable = false)
    private Integer sucursalId;

    @Column(nullable = false)
    private String fechaInicio; // "2026-05-10" — String en vez de LocalDate

    @Column(nullable = false)
    private String fechaFin;   // "2026-05-17" — String en vez de LocalDate

    // "PENDIENTE", "ACTIVA", "FINALIZADA", "CANCELADA"
    @Column(nullable = false)
    private String estado;
}
