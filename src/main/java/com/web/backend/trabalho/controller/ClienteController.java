package com.web.backend.trabalho.controller;

import com.web.backend.trabalho.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/user")
    public String getUser() {
        return "Nome: Fulano \n" +
                "Idade: 22";
    }
}
