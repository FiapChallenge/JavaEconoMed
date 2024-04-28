package br.com.fiap.economed.infrastructure.gateways.mappers;

import br.com.fiap.economed.domain.entities.Cliente;
import br.com.fiap.economed.infrastructure.persistence.dbEntities.ClienteDb;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {
    public ClienteDb toEntity(Cliente clienteDomainObj) {
        return new ClienteDb(
                null,
                clienteDomainObj.rg(),
                clienteDomainObj.nome(),
                clienteDomainObj.telefone(),
                clienteDomainObj.email(),
                clienteDomainObj.dataNascimento(),
                clienteDomainObj.cpf(),
                clienteDomainObj.estadoCivil(),
                clienteDomainObj.convenioId());
    }

    public Cliente toDomainObj(ClienteDb clienteDb) {
        return new Cliente(
                clienteDb.getId(),
                clienteDb.getRg(),
                clienteDb.getNome(),
                clienteDb.getTelefone(),
                clienteDb.getEmail(),
                clienteDb.getDataNascimento(),
                clienteDb.getCpf(),
                clienteDb.getEstadoCivil(),
                clienteDb.getConvenioId()
        );
    }

    public List<Cliente> toDomainList(List<ClienteDb> clienteDbList) {
        return clienteDbList.stream().map(this::toDomainObj).collect(Collectors.toList());
    }
}
