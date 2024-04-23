package br.com.fiap.economed.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entity.HistoricoSaudeCliente;

import java.util.Optional;

public interface HistoricoSaudeClienteRepository extends JpaRepository<HistoricoSaudeCliente, Long> {
    Optional<HistoricoSaudeCliente> findByClienteId(Long clienteId);

}
