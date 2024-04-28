package br.com.fiap.economed.infrastructure.controllers.dto.clienteEndereco;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.EnderecoClienteDb;

public record DetalhesEnderecoClienteDto(
        Long id,
        Long clienteId,
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep) {

    public DetalhesEnderecoClienteDto(EnderecoClienteDb enderecoCliente) {
        this(
                enderecoCliente.getId(),
                enderecoCliente.getClienteId(),
                enderecoCliente.getRua(),
                enderecoCliente.getNumero(),
                enderecoCliente.getCidade(),
                enderecoCliente.getEstado(),
                enderecoCliente.getCep());
    }
}