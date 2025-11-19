package com.simu.saep.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MovimentoEstoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Componente componente;

    private int quantidade;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipo;

    private String responsavel;

    private LocalDateTime data = LocalDateTime.now();

    public MovimentoEstoque(Componente componente, Long id, int quantidade, String responsavel, TipoMovimento tipo) {
        this.componente = componente;
        this.id = id;
        this.quantidade = quantidade;
        this.responsavel = responsavel;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoMovimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimento tipo) {
        this.tipo = tipo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public enum TipoMovimento { ENTRADA, SAIDA }
    
    public MovimentoEstoque() {
    }

    
    
}
