package com.web.backend.trabalho.controller;

import com.web.backend.trabalho.model.entities.Cliente;
import com.web.backend.trabalho.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public void cadastrar(@RequestBody Cliente cliente) {
        this.clienteService.cadastrar(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        Cliente cliente = this.clienteService.buscarPorId(id);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        return cliente;
    }

    @GetMapping
    public List<Cliente> buscarTodos() {
        return this.clienteService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable final Long id) {
        this.clienteService.deletar(id);
    }
}
