package br.com.fiap.economed.application.interfaces.gateways.repositories;

import br.com.fiap.economed.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
