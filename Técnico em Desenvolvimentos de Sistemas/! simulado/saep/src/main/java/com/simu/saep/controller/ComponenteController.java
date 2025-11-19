package com.simu.saep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simu.saep.model.Componente;
import com.simu.saep.repository.ComponenteRepository;

@Controller
@RequestMapping("/componentes")
public class ComponenteController {
    
    @Autowired
    private ComponenteRepository compRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", compRepository.findAll());
        return "componentes-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("componente", new Componente());
        return "componentes-form";
    }

    @PostMapping("/salvar")
    public String salvar(Componente componente) {
        compRepository.save(componente);
        return "redirect:/componentes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("componente", compRepository.findById(id).get());
        return "componentes-form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        compRepository.deleteById(id);
        return "redirect:/componentes";
    }
}
