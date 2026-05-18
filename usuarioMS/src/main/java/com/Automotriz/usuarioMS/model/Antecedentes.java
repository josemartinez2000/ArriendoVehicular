package com.Automotriz.usuarioMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "antecedentes")
public class Antecedentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // "VIGENTE", "SUSPENDIDA", "VENCIDA"
    @Column(nullable = false)
    private String estadoLicencia;

    @Column(nullable = false)
    private Integer registroMultas;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}
