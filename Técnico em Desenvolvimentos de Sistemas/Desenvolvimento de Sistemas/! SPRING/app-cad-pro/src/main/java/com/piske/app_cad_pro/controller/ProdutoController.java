package com.piske.app_cad_pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.piske.app_cad_pro.model.Produto;
import com.piske.app_cad_pro.service.ProdutoService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("produtos", produtoService.listProdutos());
        return "produtos";
    }

    @PostMapping("/produto/salvar")
    public String salvarProduto(@ModelAttribute Produto produto, @RequestParam("imagem") MultipartFile imagem)
            throws IOException {
        if (!imagem.isEmpty()) {
            produto.setImagemBytes(imagem.getBytes());
        }
        produtoService.saveProduto(produto);
        return "redirect:/produtos";
    }

    @PostMapping("/produto/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deleteById(id);
        return "redirect:/produtos";
    }

    @GetMapping("/produto/imagem/{id}")
    public ResponseEntity<byte[]> obterImagemProduto(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        byte[] imagem = produto.getImagemBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(imagem, headers, HttpStatus.OK);
    }

    @GetMapping("/produto/detalhe/{id}")
    public ResponseEntity<Produto> obterDetalhesProduto(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        if (produto != null) {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
