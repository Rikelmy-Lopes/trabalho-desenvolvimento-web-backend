package com.web.backend.trabalho.model.services;

import com.web.backend.trabalho.model.entities.Produto;
import com.web.backend.trabalho.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void cadastrar(Produto produto) {
        this.produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        return this.produtoRepository.getReferenceById(id);
    }

    public List<Produto> buscarTodos() {
        return this.produtoRepository.findAll();
    }

    public void deletar(Long id) {
        this.produtoRepository.deleteById(id);
    }

}
