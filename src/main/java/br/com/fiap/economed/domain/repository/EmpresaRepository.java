package br.com.fiap.economed.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entity.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
