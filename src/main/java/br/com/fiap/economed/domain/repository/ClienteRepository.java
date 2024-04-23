package br.com.fiap.economed.domain.repository;

import br.com.fiap.economed.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
