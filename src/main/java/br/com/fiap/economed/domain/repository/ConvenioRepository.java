package br.com.fiap.economed.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entity.Convenio;


public interface ConvenioRepository extends JpaRepository<Convenio, Long>{
    
}
