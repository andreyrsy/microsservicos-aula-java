package dev.andreyrsy.msprodutos.controller;

import dev.andreyrsy.msprodutos.model.Produto;
import dev.andreyrsy.msprodutos.repository.ProdutoRepository;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto bsucarPorId(@PathVariable Long id){
        return produtoRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

}



