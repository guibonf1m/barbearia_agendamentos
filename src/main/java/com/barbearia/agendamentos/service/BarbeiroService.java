package com.barbearia.agendamentos.service;

import com.barbearia.agendamentos.model.Barbeiro;
import com.barbearia.agendamentos.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    @Autowired
    public BarbeiroService(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
    }

    public List<Barbeiro> listarTodos() {
        return barbeiroRepository.findAll();
    }

    public Optional<Barbeiro> buscarPorId(Long id) {
        return barbeiroRepository.findById(id);
    }

    public Barbeiro salvar(Barbeiro barbeiro) {
        return barbeiroRepository.save(barbeiro);
    }

    public void deletar(Long id) {
        barbeiroRepository.deleteById(id);
    }
}