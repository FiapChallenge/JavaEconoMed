package br.com.fiap.economed.domain.entities;

public record EnderecoCliente(
        Long clienteId,
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep
) {
}
