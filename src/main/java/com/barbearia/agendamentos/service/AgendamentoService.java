package com.barbearia.agendamentos.service;

import com.barbearia.agendamentos.model.Agendamento;
import com.barbearia.agendamentos.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }
}