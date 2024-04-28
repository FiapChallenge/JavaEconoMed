package br.com.fiap.economed.infrastructure.controllers.dto.cliente.create;

import br.com.fiap.economed.domain.entities.enums.EstadoCivilCliente;

import java.time.LocalDate;

public record CreateClienteRequest(
        String rg,
        String nome,
        String telefone,
        String email,
        LocalDate dataNascimento,
        String cpf,
        EstadoCivilCliente estadoCivil,
        Long convenioId
) {
}
