package com.piske.app_cad_pro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.piske.app_cad_pro.model.Produto;
import com.piske.app_cad_pro.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;

    public Produto saveProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listProdutos(){
        return produtoRepository.findAll();
    }
    
    public Produto findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deleteById(Long id){
        produtoRepository.deleteById(id);
    }
}
