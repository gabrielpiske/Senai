package br.com.senai.adopet.api.dto;

import jakarta.validation.constraints.NotNull;

public record AprovacaoAdocaoDto(@NotNull Long idAdocao) {
}
