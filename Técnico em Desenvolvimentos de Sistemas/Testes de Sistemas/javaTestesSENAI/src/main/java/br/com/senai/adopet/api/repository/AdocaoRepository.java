package br.com.senai.adopet.api.repository;

import br.com.senai.adopet.api.model.Adocao;
import br.com.senai.adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

}
