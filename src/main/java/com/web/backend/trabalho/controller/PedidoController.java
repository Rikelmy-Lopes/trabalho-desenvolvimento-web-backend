package com.web.backend.trabalho.controller;

import com.web.backend.trabalho.dto.PedidoDTO;
import com.web.backend.trabalho.exceptions.NaoEncontradoException;
import com.web.backend.trabalho.model.entities.Pedido;
import com.web.backend.trabalho.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public void cadastrar(@RequestBody PedidoDTO pedidoDTO) {
        this.pedidoService.cadastrar(pedidoDTO);
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        Pedido pedido = this.pedidoService.buscarPorId(id);
        if (pedido == null) {
            throw new NaoEncontradoException("Pedido não encontrado!");
        }

        return pedido;
    }

    @GetMapping
    public List<Pedido> buscarTodos() {
        return this.pedidoService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        this.pedidoService.deletar(id);
        return "Pedido com id: " + id + " deletado com sucesso!";
    }
}
