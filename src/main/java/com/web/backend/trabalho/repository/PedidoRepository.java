package com.web.backend.trabalho.repository;

import com.web.backend.trabalho.model.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
