package br.com.fiap.economed.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entity.HistoricoHospitalCliente;

import java.util.Optional;

public interface HistoricoHospitalClienteRepository extends JpaRepository<HistoricoHospitalCliente, Long> {
    Optional<HistoricoHospitalCliente> findByClienteId(Long clienteId);

}
