package br.com.fiap.economed.infrastructure.controllers.dto.unidade;


public record AtualizacaoUnidadeDto(
        Long empresaId,
        String nome,
        String telefone,
        String email,
        String tipo,
        Integer capacidade,
        String especialidades) {
}
