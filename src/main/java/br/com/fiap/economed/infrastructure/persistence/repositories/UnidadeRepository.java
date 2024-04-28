package br.com.fiap.economed.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.UnidadeDb;


public interface UnidadeRepository extends JpaRepository<UnidadeDb, Long>{
    
}
