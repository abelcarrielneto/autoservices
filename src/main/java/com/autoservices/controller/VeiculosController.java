package com.autoservices.controller;

import com.autoservices.model.Veiculo;
import com.autoservices.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public List<Veiculo> lista(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> listaUnico(@PathVariable(value="id") Long id){
        return produtoRepository.findById(id);
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo produtoVeiculo){
        return produtoRepository.save(produtoVeiculo);
    }

    @PutMapping
    public Veiculo atualizar(@RequestBody Veiculo produtoVeiculo){
        return produtoRepository.save(produtoVeiculo);
    }

    @DeleteMapping
    public void deleta(@RequestBody Veiculo produtoVeiculo){
        produtoRepository.delete(produtoVeiculo);
    }
}
