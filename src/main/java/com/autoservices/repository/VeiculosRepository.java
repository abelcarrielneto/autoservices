package com.autoservices.repository;

import com.autoservices.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculosRepository extends JpaRepository<Veiculo, Long> {
   Optional<Veiculo> findById(Long id);

}
