package br.com.fiap.economed.infrastructure.persistence.repositories;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.EnderecoClienteDb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoClienteDb, Long> {
    Optional<EnderecoClienteDb> findByClienteId(Long clienteId);
}
