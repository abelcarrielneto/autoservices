package com.autoservices.controller;

import com.autoservices.model.Veiculo;
import com.autoservices.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
    @Autowired
    VeiculosRepository veiculosRepository;

    @GetMapping
    public ResponseEntity<List<Veiculo>> listar(){
        return ResponseEntity.ok(veiculosRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity listarUnico(@PathVariable(value="id") Long id){
        Optional<Veiculo> optVeiculo = veiculosRepository.findById(id);
        if (optVeiculo.isPresent()){
            return ResponseEntity.ok(optVeiculo.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping
    public ResponseEntity<Veiculo> salvar(@RequestBody Veiculo model){
        Veiculo v = veiculosRepository.save(model);
        return ResponseEntity.ok(v);
    }

    @PutMapping
    public ResponseEntity<Veiculo> atualizar(@RequestBody Veiculo model){
        return ResponseEntity.ok(veiculosRepository.save(model));
    }

    @DeleteMapping
    public ResponseEntity remover(@RequestBody Veiculo model){
        veiculosRepository.delete(model);
        return ResponseEntity.noContent().build();
    }
}