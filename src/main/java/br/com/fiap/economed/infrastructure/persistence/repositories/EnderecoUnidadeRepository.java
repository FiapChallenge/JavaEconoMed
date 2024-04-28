package br.com.fiap.economed.infrastructure.persistence.repositories;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.EnderecoUnidadeDb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoUnidadeRepository extends JpaRepository<EnderecoUnidadeDb, Long> {
    Optional<EnderecoUnidadeDb> findByUnidadeId(Long unidadeId);

}
