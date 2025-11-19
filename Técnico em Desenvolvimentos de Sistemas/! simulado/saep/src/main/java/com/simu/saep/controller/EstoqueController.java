package com.simu.saep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simu.saep.model.MovimentoEstoque;
import com.simu.saep.repository.ComponenteRepository;
import com.simu.saep.service.EstoqueService;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private ComponenteRepository compRepository;

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public String historico(Model model) {
        model.addAttribute("movimentos", estoqueService.getAll());
        return "estoque-historico";
    }

    @GetMapping("/movimentar/{id}")
    public String movimentar(@PathVariable Long id, Model model) {
        model.addAttribute("componente", compRepository.findById(id).get());
        model.addAttribute("movimento", new MovimentoEstoque());
        return "estoque-movimentar";
    }

    @PostMapping("/registrar")
    public String registrar(MovimentoEstoque movimento) {
        estoqueService.registrarMovimento(movimento);
        return "redirect:/componentes";
    }
}
