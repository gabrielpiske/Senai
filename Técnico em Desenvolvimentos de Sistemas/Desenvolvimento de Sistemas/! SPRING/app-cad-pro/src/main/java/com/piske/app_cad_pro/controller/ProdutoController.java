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

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(Produto produto, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            produto.setImagemBytes(file.getBytes());
        }
        produtoService.saveProduto(produto);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        model.addAttribute("produto", produtoService.listProdutos());
        return "listar";
    }

    @GetMapping("/produto/imagem/{id}")
    public ResponseEntity<byte[]> obterImagmeProduto(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        byte[] imagem = produto.getImagemBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(imagem, headers, HttpStatus.OK);
    }

    @PostMapping("/produto/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deleteById(id);
        return "redirect:/listar";
    }

    @GetMapping("/produto/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Produto produto = produtoService.findById(id);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "editar_produto";
        } else {
            return "redirect:/produto/lista";
        }
    }

    @PostMapping("/produto/editar")
    public String editarProduto(@ModelAttribute Produto produto) {
        produtoService.saveProduto(produto);
        return "redirect:/listar";
    }

    @PostMapping("/produto/salvar")
    public String salvarProduto(@ModelAttribute Produto produto, @RequestParam("imagem") MultipartFile imagem) {
        if (!imagem.isEmpty()) {
            produto.setImagem(imagem);
        }
        produtoService.saveProduto(produto);
        return "redirect:/listar";
    }
}
