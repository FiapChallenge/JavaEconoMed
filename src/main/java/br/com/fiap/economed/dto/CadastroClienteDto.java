package br.com.fiap.economed.dto;

import java.time.LocalDate;

public record CadastroClienteDto(
        String rg,
        String nome,
        String telefone,
        String email,
        LocalDate dataNascimento,
        String cpf,
        String estadoCivil,
        String temConvenio) {
}
