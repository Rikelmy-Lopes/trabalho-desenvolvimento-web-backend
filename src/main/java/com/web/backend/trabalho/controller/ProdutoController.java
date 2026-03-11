package com.web.backend.trabalho.controller;

import com.web.backend.trabalho.exceptions.NaoEncontradoException;
import com.web.backend.trabalho.model.entities.Produto;
import com.web.backend.trabalho.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public void cadastrar(@RequestBody Produto produto) {
        this.produtoService.cadastrar(produto);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        Produto produto = this.produtoService.buscarPorId(id);
        if (produto == null) {
            throw new NaoEncontradoException("Produto não encontrado!");
        }

        return produto;
    }

    @GetMapping
    public List<Produto> buscarTodos() {
        return this.produtoService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable final Long id) {
        this.produtoService.deletar(id);
    }
}
