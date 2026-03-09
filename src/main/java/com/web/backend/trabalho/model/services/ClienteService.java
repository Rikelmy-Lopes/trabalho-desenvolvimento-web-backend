package com.web.backend.trabalho.model.services;

import com.web.backend.trabalho.model.entities.Cliente;
import com.web.backend.trabalho.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void cadastrar(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return this.clienteRepository.getReferenceById(id);
    }

    public List<Cliente> buscarTodos() {
        return this.clienteRepository.findAll();
    }

    public void deletar(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
