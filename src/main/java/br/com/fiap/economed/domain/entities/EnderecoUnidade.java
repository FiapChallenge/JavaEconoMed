package br.com.fiap.economed.domain.entities;

public record EnderecoUnidade(
        Long unidadeId,
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep
) {
}
