package br.com.fiap.economed.application.usecases.cliente;

import br.com.fiap.economed.application.gateways.ClienteGateway;
import br.com.fiap.economed.domain.entities.Cliente;

import java.awt.print.Pageable;
import java.util.List;

public class ClienteInteractor {
    private final ClienteGateway clienteGateway;

    public ClienteInteractor(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public List<Cliente> listAll() {
        return clienteGateway.listAll();
    }

    public Cliente create(Cliente cliente) {
        return clienteGateway.create(cliente);
    }
}
