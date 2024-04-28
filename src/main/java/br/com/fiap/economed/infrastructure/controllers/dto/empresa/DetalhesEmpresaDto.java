package br.com.fiap.economed.infrastructure.controllers.dto.empresa;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.EmpresaDb;

public record DetalhesEmpresaDto(
        Long id,
        String cnpj,
        String nome,
        String tipo,
        String telefone,
        String email,
        String areaAtuacao) {

    public DetalhesEmpresaDto(EmpresaDb empresa) {
        this(
                empresa.getId(),
                empresa.getCnpj(),
                empresa.getNome(),
                empresa.getTipo(),
                empresa.getTelefone(),
                empresa.getEmail(),
                empresa.getAreaAtuacao());
    }
}
