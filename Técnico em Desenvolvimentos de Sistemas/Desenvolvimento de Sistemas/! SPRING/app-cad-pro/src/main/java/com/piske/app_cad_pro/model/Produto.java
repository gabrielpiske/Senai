package com.piske.app_cad_pro.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String categoria;
    private String fornecedor;

    @Transient
    private MultipartFile imagem;

    @Lob
    @Column(name = "imagem")
    private byte[] imagemBytes;

    public void setImagem(MultipartFile imagem) {
        this.imagem = imagem;
        try {
            this.imagemBytes = imagem.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
