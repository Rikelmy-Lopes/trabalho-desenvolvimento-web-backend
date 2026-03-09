package com.web.backend.trabalho.controller;

import com.web.backend.trabalho.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
}
