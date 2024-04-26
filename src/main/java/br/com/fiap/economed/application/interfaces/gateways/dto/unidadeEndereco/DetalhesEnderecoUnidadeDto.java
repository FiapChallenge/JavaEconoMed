package br.com.fiap.economed.application.interfaces.gateways.dto.unidadeEndereco;

import br.com.fiap.economed.domain.entities.EnderecoUnidade;



public record DetalhesEnderecoUnidadeDto(
        Long id,
        Long unidadeId,
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep) {

    public DetalhesEnderecoUnidadeDto(EnderecoUnidade enderecoUnidade) {
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