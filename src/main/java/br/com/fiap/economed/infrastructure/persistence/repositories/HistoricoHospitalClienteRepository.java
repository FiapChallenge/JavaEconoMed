package br.com.fiap.economed.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.HistoricoHospitalClienteDb;

import java.util.Optional;

public interface HistoricoHospitalClienteRepository extends JpaRepository<HistoricoHospitalClienteDb, Long> {
    Optional<HistoricoHospitalClienteDb> findByClienteId(Long clienteId);

}
