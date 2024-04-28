package br.com.fiap.economed.infrastructure.controllers.dto.unidade;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.UnidadeDb;

public record DetalhesUnidadeDto(
        Long id,
        Long empresaId,
        String nome,
        String telefone,
        String email,
        String tipo,
        Integer capacidade,
        String especialidades) {

    public DetalhesUnidadeDto(UnidadeDb unidade) {
        this(
                unidade.getId(),
                unidade.getEmpresaId(),
                unidade.getNome(),
                unidade.getTelefone(),
                unidade.getEmail(),
                unidade.getTipo(),
                unidade.getCapacidade(),
                unidade.getEspecialidades());
    }
}