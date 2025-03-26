package br.com.senai.adopet.api.service;

import org.junit.jupiter.api.Test;

import br.com.senai.adopet.api.dto.CadastroAbrigoDto;
import br.com.senai.adopet.api.dto.CadastroPetDto;
import br.com.senai.adopet.api.model.Abrigo;
import br.com.senai.adopet.api.model.Pet;
import br.com.senai.adopet.api.model.ProbabilidadeAdocao;
import br.com.senai.adopet.api.model.TipoPet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;


/**
 *
 * @author gabriel_piske
 */
public class CalculadoraProbabilidadeAdocaoTest {
    
    public CalculadoraProbabilidadeAdocaoTest() {
    }

    @Test
    public void testaIdade4Peso4kgRetornaAlta() {
        // idade 4 anos, peso 4kg deve retorna probabilidade alta
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto("abrigo felz", "47999999999", "abrigofeliz@gmail.com"));
        Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO, "Regiane", "Siames", 4, "Laranja", 4f), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }
    
}
