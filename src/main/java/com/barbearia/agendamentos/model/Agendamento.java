package com.barbearia.agendamentos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.barbearia.agendamentos.model.Barbeiro;

@Data
@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Barbeiro barbeiro;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String status; // Ex: PENDENTE, CONFIRMADO, CANCELADO
}