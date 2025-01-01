package com.barbearia.agendamentos.controller;

import com.barbearia.agendamentos.model.Barbeiro;
import com.barbearia.agendamentos.service.BarbeiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

    @GetMapping
    public List<Barbeiro> listarTodos() {
        return barbeiroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbeiro> buscarPorId(@PathVariable Long id) {
        return barbeiroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Barbeiro salvar(@RequestBody Barbeiro barbeiro) {
        return barbeiroService.salvar(barbeiro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        barbeiroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}