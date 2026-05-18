package com.Automotriz.notificacionesMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // "EMAIL", "SMS", "PUSH"
    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer reservaId;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String fechaNotificacion; // String en vez de LocalDate

    // "ENVIADA", "PENDIENTE", "FALLIDA"
    @Column(nullable = false)
    private String estado;
}
