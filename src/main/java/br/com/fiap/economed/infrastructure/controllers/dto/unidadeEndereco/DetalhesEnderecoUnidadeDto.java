package br.com.fiap.economed.infrastructure.controllers.dto.unidadeEndereco;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.EnderecoUnidadeDb;



public record DetalhesEnderecoUnidadeDto(
        Long id,
        Long unidadeId,
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep) {

    public DetalhesEnderecoUnidadeDto(EnderecoUnidadeDb enderecoUnidade) {
        this(
                enderecoUnidade.getId(),
                enderecoUnidade.getUnidadeId(),
                enderecoUnidade.getRua(),
                enderecoUnidade.getNumero(),
                enderecoUnidade.getCidade(),
                enderecoUnidade.getEstado(),
                enderecoUnidade.getCep());
    }
}