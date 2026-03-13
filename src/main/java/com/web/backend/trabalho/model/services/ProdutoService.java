package com.web.backend.trabalho.model.services;

import com.web.backend.trabalho.exceptions.NaoEncontradoException;
import com.web.backend.trabalho.model.entities.Produto;
import com.web.backend.trabalho.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void cadastrar(Produto produto) {
        this.produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        Optional<Produto> optionalProduto = this.produtoRepository.findById(id);
        if (optionalProduto.isEmpty()) {
            throw new NaoEncontradoException("Produto não encontrado");
        }

        return optionalProduto.get();
    }

    public List<Produto> buscarTodos() {
        return this.produtoRepository.findAll();
    }

    public void deletar(Long id) {
        Produto produto = this.buscarPorId(id);

        this.produtoRepository.delete(produto);
    }

}
