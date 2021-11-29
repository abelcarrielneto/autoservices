package com.autoservices.controller;

import com.autoservices.model.Model;
import com.autoservices.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class Produtos {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/")
    public List<Model> lista(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Model> listaUnico(@PathVariable(value="id") Long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/")
    public Model salvar(@RequestBody Model produtoModel){
        return produtoRepository.save(produtoModel);
    }

    @PutMapping("/")
    public Model atualizar(@RequestBody Model produtoModel){
        return produtoRepository.save(produtoModel);
    }

    @DeleteMapping ("/")
    public void deleta (@RequestBody Model produtoModel){
        produtoRepository.delete(produtoModel);
    }
}
