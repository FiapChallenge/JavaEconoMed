package br.com.fiap.economed.infrastructure.controllers.dto.clienteEndereco;

public record AtualizacaoEnderecoClienteDto(
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep) {
}
