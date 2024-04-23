package br.com.fiap.economed.infrastructure.presentation.dto.clienteEndereco;

public record AtualizacaoEnderecoClienteDto(
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep) {
}
