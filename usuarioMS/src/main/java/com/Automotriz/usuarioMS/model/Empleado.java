package com.Automotriz.usuarioMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descripcion;

    // Solo ID porque sucursal es otro microservicio
    @Column(name = "sucursal_id", nullable = false)
    private Integer sucursalId;

    @Column(nullable = false)
    private String infoBancaria;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
