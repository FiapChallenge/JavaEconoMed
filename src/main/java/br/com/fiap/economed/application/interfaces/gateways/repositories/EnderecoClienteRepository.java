package br.com.fiap.economed.application.interfaces.gateways.repositories;

import br.com.fiap.economed.domain.entities.EnderecoCliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long> {
    Optional<EnderecoCliente> findByClienteId(Long clienteId);
}
