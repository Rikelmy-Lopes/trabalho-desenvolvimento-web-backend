package com.web.backend.trabalho.model.services;

import com.web.backend.trabalho.exceptions.NaoEncontradoException;
import com.web.backend.trabalho.model.entities.Cliente;
import com.web.backend.trabalho.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void cadastrar(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(id);
        if (optionalCliente.isEmpty()) {
            throw new NaoEncontradoException("Cliente não encontrado!");
        }

        return optionalCliente.get();
    }

    public List<Cliente> buscarTodos() {
        return this.clienteRepository.findAll();
    }

    public void deletar(Long id) {
        Cliente cliente = this.buscarPorId(id);

        this.clienteRepository.delete(cliente);
    }
}
