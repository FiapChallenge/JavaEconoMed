package br.com.fiap.economed.application.interfaces.gateways.dto.cliente;


import java.time.LocalDate;

import br.com.fiap.economed.domain.entities.enums.EstadoCivilCliente;

public record AtualizacaoClienteDto(
        String rg,
        String nome,
        String telefone,
        String email,
        LocalDate dataNascimento,
        String cpf,
        EstadoCivilCliente estadoCivil,
        Long convenioId) {
}
