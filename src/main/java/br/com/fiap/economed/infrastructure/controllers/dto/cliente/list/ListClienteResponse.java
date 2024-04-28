package br.com.fiap.economed.infrastructure.controllers.dto.cliente.list;

public record ListClienteResponse (
        Long id,
        String nome,
        String telefone,
        String email,
        String cpf,
        String rg,
        String dataNascimento,
        String estadoCivil,
        Long convenioId
) {
}
