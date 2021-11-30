package com.autoservices.controller;

import com.autoservices.model.Veiculo;
import com.autoservices.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
    @Autowired
    VeiculosRepository veiculosRepository;

    @GetMapping
    public List<Veiculo> lista(){
        return veiculosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> listaUnico(@PathVariable(value="id") Long id){
        return veiculosRepository.findById(id);
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo produtoVeiculo){
        return veiculosRepository.save(produtoVeiculo);
    }

    @PutMapping
    public Veiculo atualizar(@RequestBody Veiculo produtoVeiculo){
        return veiculosRepository.save(produtoVeiculo);
    }

    @DeleteMapping
    public void deleta(@RequestBody Veiculo produtoVeiculo){
        veiculosRepository.delete(produtoVeiculo);
    }
}
