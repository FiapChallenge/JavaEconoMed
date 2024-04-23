package br.com.fiap.economed.infrastructure.presentation.dto.cliente;


import java.time.LocalDate;

import br.com.fiap.economed.domain.entity.enums.EstadoCivilCliente;

public record CadastroClienteDto(
        String rg,
        String nome,
        String telefone,
        String email,
        LocalDate dataNascimento,
        String cpf,
        EstadoCivilCliente estadoCivil,
        Long convenioId) {
}
