package br.com.fiap.economed.infrastructure.controllers.dto.cliente;

import br.com.fiap.economed.domain.entities.Cliente;
import br.com.fiap.economed.infrastructure.controllers.dto.cliente.create.CreateClienteRequest;
import br.com.fiap.economed.infrastructure.controllers.dto.cliente.create.CreateClienteResponse;
import br.com.fiap.economed.infrastructure.controllers.dto.cliente.list.ListClienteResponse;

public class ClienteDTOMapper {

    public ListClienteResponse toListResponse(Cliente cliente) {
        return new ListClienteResponse(
                cliente.id(),
                cliente.rg(),
                cliente.nome(),
                cliente.telefone(),
                cliente.email(),
                cliente.dataNascimento().toString(),
                cliente.cpf(),
                cliente.estadoCivil().toString(),
                cliente.convenioId()
        );
    }

    public CreateClienteResponse toResponse(Cliente cliente) {
        return new CreateClienteResponse(
                cliente.rg(),
                cliente.nome(),
                cliente.telefone(),
                cliente.email(),
                cliente.dataNascimento(),
                cliente.cpf(),
                cliente.estadoCivil(),
                cliente.convenioId()
        );
    }

    public Cliente toCliente(CreateClienteRequest request) {
        return new Cliente(
                null,
                request.rg(),
                request.nome(),
                request.telefone(),
                request.email(),
                request.dataNascimento(),
                request.cpf(),
                request.estadoCivil(),
                request.convenioId()
        );
    }
}
