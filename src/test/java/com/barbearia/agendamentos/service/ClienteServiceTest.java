package com.barbearia.agendamentos.service;

import com.barbearia.agendamentos.model.Cliente;
import com.barbearia.agendamentos.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        clienteRepository.deleteAll();  // Limpa os dados antes de cada teste
    }

    @Test
    public void testSalvarCliente() {
        // Criar um cliente novo (sem o id, pois o id será gerado automaticamente)
        Cliente cliente = new Cliente("João Silva", "joao@exemplo.com", "123456789");

        // Salvar o cliente usando o serviço
        Cliente clienteSalvo = clienteService.salvar(cliente);

        // Validar que o cliente foi salvo corretamente
        assertNotNull(clienteSalvo);
        assertEquals("João Silva", clienteSalvo.getNome());
        assertEquals("joao@exemplo.com", clienteSalvo.getEmail());  // Verificando o email
        assertEquals("123456789", clienteSalvo.getTelefone());  // Verificando o telefone
    }

    @Test
    public void testListarClientes() {
        // Criar e salvar um cliente
        Cliente cliente1 = new Cliente("João Silva", "joao@exemplo.com", "123456789");
        clienteRepository.save(cliente1);

        // Listar os clientes
        List<Cliente> clientes = clienteService.listarTodos();

        // Validar a lista de clientes
        assertNotNull(clientes);
        assertEquals(1, clientes.size());  // Espera-se 1 cliente na lista
        assertEquals("João Silva", clientes.get(0).getNome());  // Validando o nome do cliente
    }
}
