package br.com.senai.adopet.api.validacoes;

import br.com.senai.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.senai.adopet.api.exception.ValidacaoException;
import br.com.senai.adopet.api.model.StatusAdocao;
import br.com.senai.adopet.api.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        boolean petTemAdocaoEmAndamento = adocaoRepository
                .existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);

        if (petTemAdocaoEmAndamento) {
            throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }

}
