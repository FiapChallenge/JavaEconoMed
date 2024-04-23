package br.com.fiap.economed.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entity.Unidade;


public interface UnidadeRepository extends JpaRepository<Unidade, Long>{
    
}
