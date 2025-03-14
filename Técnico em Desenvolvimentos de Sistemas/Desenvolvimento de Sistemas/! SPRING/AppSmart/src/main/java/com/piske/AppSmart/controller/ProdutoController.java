package com.piske.AppSmart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.piske.AppSmart.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    
    @GetMapping("/tabela")
    public String lerArquivosProdutos(Model model) {
        model.addAttribute("produtos", produtos);
        model.addAttribute("produto", new Produto());
        return "tabela";
    }

    @PostMapping("/addProduto")
    public String addProduto(@ModelAttribute Produto produto , Model model) {
        produtos.add(produto);
        model.addAttribute("produtos", produtos);
        model.addAttribute("produto", new Produto());
        return "tabela";
    }
}