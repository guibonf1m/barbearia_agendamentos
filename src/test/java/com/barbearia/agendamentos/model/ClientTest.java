package com.barbearia.agendamentos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testClienteConstructor() {
        // Alterar o id para Long, já que o construtor espera um id Long (não String)
        Cliente cliente = new Cliente("João", "joao@example.com", "123456789");

        // O id será gerado automaticamente, portanto não podemos testá-lo diretamente aqui.
        // Então, removemos a linha que verifica o id.
        assertEquals("João", cliente.getNome());
        assertEquals("joao@example.com", cliente.getEmail());
        assertEquals("123456789", cliente.getTelefone());
    }

    @Test
    void testSettersAndGetters() {
        Cliente cliente = new Cliente();
        cliente.setId(2L); // Alterar o tipo de id para Long (não String)
        cliente.setNome("Maria");
        cliente.setEmail("maria@example.com");
        cliente.setTelefone("987654321");

        assertEquals(2L, cliente.getId());
        assertEquals("Maria", cliente.getNome());
        assertEquals("maria@example.com", cliente.getEmail());
        assertEquals("987654321", cliente.getTelefone());
    }
}

