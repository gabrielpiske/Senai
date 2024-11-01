package com.psii.forn_ped.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.forn_ped.model.Fornecedor;
import com.psii.forn_ped.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public String listFornecedores(Model model){
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        model.addAttribute("fornecedores", fornecedores);
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedor"; //lembra de criar o fornecedor.html
    }

    @PostMapping
    public String addFornecedores(Fornecedor fornecedor){
        fornecedorService.save(fornecedor);
        return "redirect:/fornecedores";
    }
}
