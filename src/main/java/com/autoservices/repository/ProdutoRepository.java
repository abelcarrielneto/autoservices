package com.autoservices.repository;

import com.autoservices.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
   Optional<ProdutoModel> findById(Long id);

}
