package br.com.fiap.economed.application.interfaces.gateways.repositories;

import br.com.fiap.economed.domain.entities.EnderecoUnidade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoUnidadeRepository extends JpaRepository<EnderecoUnidade, Long> {
    Optional<EnderecoUnidade> findByUnidadeId(Long unidadeId);

}
