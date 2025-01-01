package com.barbearia.agendamentos.service;

import com.barbearia.agendamentos.model.Cliente;
import com.barbearia.agendamentos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}