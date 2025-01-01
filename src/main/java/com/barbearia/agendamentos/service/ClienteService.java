package com.barbearia.agendamentos.service;

import com.barbearia.agendamentos.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente salvar(Cliente cliente);
    List<Cliente> listarTodos();
    Optional<Cliente> buscarPorId(Long id);
    void deletar(Long id);
}