package com.Automotriz.documentosMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer reservaId;

    @Column(nullable = false)
    private String fechaEmision; // String en vez de LocalDate

    // "PENDIENTE", "FIRMADO", "ANULADO"
    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String clausulas;
}
