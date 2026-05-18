package com.Automotriz.pagosMS.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer reservaId;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private String fechaPago; // String en vez de LocalDate

    // "PENDIENTE", "PAGADO", "RECHAZADO"
    @Column(nullable = false)
    private String estadoPago;

    // "DEBITO", "CREDITO", "TRANSFERENCIA", "EFECTIVO"
    @Column(nullable = false)
    private String metodoPago;
}
