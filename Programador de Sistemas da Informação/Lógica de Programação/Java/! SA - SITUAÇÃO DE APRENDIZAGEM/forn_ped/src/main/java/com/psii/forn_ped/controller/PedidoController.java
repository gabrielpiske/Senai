package com.psii.forn_ped.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.forn_ped.model.Pedido;
import com.psii.forn_ped.service.FornecedorService;
import com.psii.forn_ped.service.PedidoService;
import com.psii.forn_ped.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listPedidos(Model model){
        List<Pedido> pedidos = pedidoService.findAll();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("fornecedores", fornecedorService.findAll());
        model.addAttribute("produtos", produtoService.findAll());
        return "pedido";
    }

    @PostMapping
    public String savePedido(Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedidos";
    }
    
}
