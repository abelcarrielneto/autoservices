package com.autoservices.repository;

import com.autoservices.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Model, Long> {
   Optional<Model> findById(Long id);

}
