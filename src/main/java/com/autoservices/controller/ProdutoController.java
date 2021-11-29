package com.autoservices.controller;

import com.autoservices.model.ProdutoModel;
import com.autoservices.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/")
    public List<ProdutoModel> lista(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> listaUnico(@PathVariable(value="id") Long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/")
    public ProdutoModel salvar(@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    @PutMapping("/")
    public ProdutoModel atualizar(@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    @DeleteMapping ("/")
    public void deleta (@RequestBody ProdutoModel produtoModel){
        produtoRepository.delete(produtoModel);
    }
}
