package com.barbearia.agendamentos.repository;

import com.barbearia.agendamentos.model.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
}

