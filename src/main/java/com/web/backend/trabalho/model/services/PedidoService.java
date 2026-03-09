package com.web.backend.trabalho.model.services;

import com.web.backend.trabalho.model.entities.Pedido;
import com.web.backend.trabalho.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public void cadastrar(Pedido pedido) {
        this.pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return this.pedidoRepository.getReferenceById(id);
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoRepository.findAll();
    }

    public void deletar(Long id) {
        this.pedidoRepository.deleteById(id);
    }
}
