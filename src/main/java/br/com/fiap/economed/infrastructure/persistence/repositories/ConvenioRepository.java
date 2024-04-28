package br.com.fiap.economed.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.ConvenioDb;


public interface ConvenioRepository extends JpaRepository<ConvenioDb, Long>{
    
}
