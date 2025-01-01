package com.barbearia.agendamentos.controller;

import com.barbearia.agendamentos.model.Cliente;
import com.barbearia.agendamentos.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Usado para simular requisições HTTP

    @MockBean
    private ClienteService clienteService;  // Mock do serviço ClienteService

    @Test
    public void testSalvarCliente() throws Exception {
        // Criando um cliente de exemplo (sem o id, pois o id será gerado automaticamente)
        Cliente cliente = new Cliente("João Silva", "joao@exemplo.com", "123456789");

        // Mockando o serviço
        when(clienteService.salvar(any(Cliente.class))).thenReturn(cliente);

        // Simulando a requisição POST para salvar o cliente
        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"nome\": \"João Silva\", \"email\": \"joao@exemplo.com\", \"telefone\": \"123456789\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("João Silva"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("joao@exemplo.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefone").value("123456789"));
    }

    @Test
    public void testListarClientes() throws Exception {
        // Criando um cliente de exemplo (sem o id, pois o id será gerado automaticamente)
        Cliente cliente1 = new Cliente("João Silva", "joao@exemplo.com", "123456789");

        // Mockando a resposta do serviço para listar os clientes
        when(clienteService.listarTodos()).thenReturn(Collections.singletonList(cliente1));

        // Simulando a requisição GET para listar todos os clientes
        mockMvc.perform(MockMvcRequestBuilders.get("/clientes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("João Silva"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("joao@exemplo.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].telefone").value("123456789"));
    }
}
