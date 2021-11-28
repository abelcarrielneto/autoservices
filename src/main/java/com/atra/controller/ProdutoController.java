package com.atra.controller;

import com.atra.model.ProdutoModel;
import com.atra.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productbd")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<ProdutoModel> listaPodutos(){
        return produtoRepository.findAll();
    }
    @GetMapping("/produto/{id}")
    public Optional<ProdutoModel> listaProdutoUnico(@PathVariable(value="id") Long id){
        return produtoRepository.findById(id);
    }
    @PostMapping("/produto")
    public ProdutoModel salvarProduto(@RequestBody ProdutoModel produtoModel){
        return this.produtoRepository.save (produtoModel);
    }
    @PutMapping("/produto")
    public ProdutoModel atualizarProduto(@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }
    @DeleteMapping ("/produto")
    public void deletaProduto (@RequestBody ProdutoModel produtoModel){
        produtoRepository.delete (produtoModel);
    }
}
