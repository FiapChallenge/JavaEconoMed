package br.com.fiap.economed.domain.repository;

import br.com.fiap.economed.domain.entity.EnderecoCliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long> {
    Optional<EnderecoCliente> findByClienteId(Long clienteId);
}
