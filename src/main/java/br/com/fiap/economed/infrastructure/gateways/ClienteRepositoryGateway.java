package br.com.fiap.economed.infrastructure.gateways;

import br.com.fiap.economed.application.gateways.ClienteGateway;
import br.com.fiap.economed.domain.entities.Cliente;
import br.com.fiap.economed.infrastructure.gateways.mappers.ClienteMapper;
import br.com.fiap.economed.infrastructure.persistence.dbEntities.ClienteDb;
import br.com.fiap.economed.infrastructure.persistence.repositories.ClienteRepository;

import java.awt.print.Pageable;
import java.util.List;

public class ClienteRepositoryGateway implements ClienteGateway {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteRepositoryGateway(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }


    @Override
    public List<Cliente> listAll() {
        return clienteMapper.toDomainList(clienteRepository.findAll());
    }

    @Override
    public Cliente create(Cliente clienteDomainObj) {
        ClienteDb clienteDb = clienteMapper.toEntity(clienteDomainObj);
        ClienteDb savedObj = clienteRepository.save(clienteDb);
        return clienteMapper.toDomainObj(savedObj);
    }


}
