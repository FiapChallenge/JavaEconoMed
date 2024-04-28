package br.com.fiap.economed.application.gateways;

import br.com.fiap.economed.domain.entities.Cliente;

import java.awt.print.Pageable;
import java.util.List;

public interface ClienteGateway {
    List<Cliente> listAll( );

    Cliente create(Cliente cliente);
}
