package com.barbearia.agendamentos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Barbeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especialidade;
}
