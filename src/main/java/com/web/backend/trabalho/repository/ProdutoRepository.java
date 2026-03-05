package com.web.backend.trabalho.repository;

import com.web.backend.trabalho.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
