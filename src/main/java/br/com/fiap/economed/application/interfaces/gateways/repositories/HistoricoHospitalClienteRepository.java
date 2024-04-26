package br.com.fiap.economed.application.interfaces.gateways.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.economed.domain.entities.HistoricoHospitalCliente;

import java.util.Optional;

public interface HistoricoHospitalClienteRepository extends JpaRepository<HistoricoHospitalCliente, Long> {
    Optional<HistoricoHospitalCliente> findByClienteId(Long clienteId);

}
