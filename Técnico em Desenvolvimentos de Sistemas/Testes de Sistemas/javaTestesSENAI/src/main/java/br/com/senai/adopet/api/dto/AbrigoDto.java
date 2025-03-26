package br.com.senai.adopet.api.dto;

import br.com.senai.adopet.api.model.Abrigo;

public record AbrigoDto(Long id, String nome) {

    public AbrigoDto(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
