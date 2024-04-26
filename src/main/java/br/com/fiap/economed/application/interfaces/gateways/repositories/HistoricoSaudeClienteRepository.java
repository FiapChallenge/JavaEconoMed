package br.com.fiap.economed.application.interfaces.gateways.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entities.HistoricoSaudeCliente;

import java.util.Optional;

public interface HistoricoSaudeClienteRepository extends JpaRepository<HistoricoSaudeCliente, Long> {
    Optional<HistoricoSaudeCliente> findByClienteId(Long clienteId);

}
