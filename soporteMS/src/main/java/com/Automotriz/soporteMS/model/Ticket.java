package com.Automotriz.soporteMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer reservaId;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String descripcion;

    // "ABIERTO", "EN_PROCESO", "CERRADO"
    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String fechaCreacion; // String en vez de LocalDate
}
