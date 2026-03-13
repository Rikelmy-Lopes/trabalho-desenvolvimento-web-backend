package com.web.backend.trabalho.model.services;

import com.web.backend.trabalho.dto.PedidoDTO;
import com.web.backend.trabalho.exceptions.NaoEncontradoException;
import com.web.backend.trabalho.model.entities.Cliente;
import com.web.backend.trabalho.model.entities.Pedido;
import com.web.backend.trabalho.model.entities.Produto;
import com.web.backend.trabalho.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    public void cadastrar(PedidoDTO pedidoDTO) {
        Cliente cliente = this.clienteService.buscarPorId(pedidoDTO.idCliente());
        Produto produto = this.produtoService.buscarPorId(pedidoDTO.idProduto());

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(pedidoDTO.quantidade());
        this.pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        Optional<Pedido> optionalPedido = this.pedidoRepository.findById(id);
        if (optionalPedido.isEmpty()) {
            throw new NaoEncontradoException("Pedido não encontrado!");
        }

        return optionalPedido.get();
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoRepository.findAll();
    }

    public void deletar(Long id) {
        Pedido pedido = this.buscarPorId(id);

        this.pedidoRepository.delete(pedido);
    }
}
