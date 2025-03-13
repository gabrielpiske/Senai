package com.piske.AppSmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
    
    @GetMapping("/produtos")
    public String mostrarProduto(Model model) {
        int id = 12;
        String produto = "Camisa Polo";
        double preco = 149.99;
        int quantidade = 15;

        model.addAttribute("id", id);
        model.addAttribute("produto", produto);
        model.addAttribute("preco", preco);
        model.addAttribute("quantidade", quantidade);

        return "produto";
    }   
}