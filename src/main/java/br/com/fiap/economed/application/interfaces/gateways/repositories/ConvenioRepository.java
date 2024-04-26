package br.com.fiap.economed.application.interfaces.gateways.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entities.Convenio;


public interface ConvenioRepository extends JpaRepository<Convenio, Long>{
    
}
