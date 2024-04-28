package br.com.fiap.economed.domain.entities;

public record Empresa(
        String cnpj,
        String nome,
        String tipo,
        String telefone,
        String email,
        String areaAtuacao
) {
}
