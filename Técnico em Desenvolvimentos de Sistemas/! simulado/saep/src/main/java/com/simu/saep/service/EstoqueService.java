package com.simu.saep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simu.saep.model.Componente;
import com.simu.saep.model.MovimentoEstoque;
import com.simu.saep.repository.ComponenteRepository;
import com.simu.saep.repository.MovimentoRepository;

@Service
public class EstoqueService {
    
    @Autowired
    private ComponenteRepository componenteRepository;

    @Autowired
    private MovimentoRepository movimentoRepository;

    public void registrarMovimento(MovimentoEstoque movimento) {
        Componente c = movimento.getComponente();

        if (movimento.getTipo() == MovimentoEstoque.TipoMovimento.ENTRADA) {
            c.setQuantidadeEstoque(c.getQuantidadeEstoque() + movimento.getQuantidade());
        } else {
            if (c.getQuantidadeEstoque() < movimento.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente!");
            }
            c.setQuantidadeEstoque(c.getQuantidadeEstoque() - movimento.getQuantidade());
        }

        componenteRepository.save(c);
        movimentoRepository.save(movimento);

        if (c.getQuantidadeEstoque() <= c.getQuantidadeMinima()) {
            System.out.println("ALERTA: Estoque mínimo atingido para: " + c.getNome());
        }
    }

    public List<Componente> getAll(){
        return componenteRepository.findAll();
    }
}
