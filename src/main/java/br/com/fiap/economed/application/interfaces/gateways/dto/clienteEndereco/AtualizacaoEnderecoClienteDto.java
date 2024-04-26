package br.com.fiap.economed.application.interfaces.gateways.dto.clienteEndereco;

public record AtualizacaoEnderecoClienteDto(
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep) {
}
