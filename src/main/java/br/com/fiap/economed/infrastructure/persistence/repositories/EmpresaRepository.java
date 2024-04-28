package br.com.fiap.economed.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.EmpresaDb;


public interface EmpresaRepository extends JpaRepository<EmpresaDb, Long>{
    
}
