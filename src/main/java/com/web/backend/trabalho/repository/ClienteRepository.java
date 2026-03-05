package com.web.backend.trabalho.repository;

import com.web.backend.trabalho.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
