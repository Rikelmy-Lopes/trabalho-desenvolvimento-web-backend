package com.web.backend.trabalho.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser() {
        return "Nome: Fulano \n" +
                "Idade: 22";
    }
}
