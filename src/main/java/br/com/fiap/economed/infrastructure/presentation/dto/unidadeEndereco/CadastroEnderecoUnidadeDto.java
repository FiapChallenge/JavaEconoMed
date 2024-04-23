package br.com.fiap.economed.infrastructure.presentation.dto.unidadeEndereco;

public record CadastroEnderecoUnidadeDto(
                Long unidadeId,
                String rua,
                String numero,
                String cidade,
                String estado,
                String cep) {
}
