package br.com.fiap.economed.infrastructure.presentation.dto.clienteEndereco;

public record CadastroEnderecoClienteDto(
                Long clienteId,
                String rua,
                String numero,
                String cidade,
                String estado,
                String cep) {
}
