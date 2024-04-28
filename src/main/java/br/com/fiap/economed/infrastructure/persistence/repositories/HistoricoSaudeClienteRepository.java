package br.com.fiap.economed.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.HistoricoSaudeClienteDb;

import java.util.Optional;

public interface HistoricoSaudeClienteRepository extends JpaRepository<HistoricoSaudeClienteDb, Long> {
    Optional<HistoricoSaudeClienteDb> findByClienteId(Long clienteId);

}
