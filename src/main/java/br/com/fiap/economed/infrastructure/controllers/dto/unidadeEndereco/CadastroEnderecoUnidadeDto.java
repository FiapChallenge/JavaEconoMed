package br.com.fiap.economed.infrastructure.controllers.dto.unidadeEndereco;

public record CadastroEnderecoUnidadeDto(
                Long unidadeId,
                String rua,
                String numero,
                String cidade,
                String estado,
                String cep) {
}
