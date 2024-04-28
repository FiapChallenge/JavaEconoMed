package br.com.fiap.economed.infrastructure.persistence.repositories;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.ClienteDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteDb, Long> {

}
