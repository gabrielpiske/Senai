package com.simu.saep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simu.saep.model.MovimentoEstoque;

public interface MovimentoRepository extends JpaRepository<MovimentoEstoque, Long>{
    
}
