package br.com.fiap.economed.infrastructure.controllers.dto.cliente;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.ClienteDb;
import br.com.fiap.economed.domain.entities.enums.EstadoCivilCliente;

import java.time.LocalDate;

public record DetalhesClienteDto(
        Long id,
        String rg,
        String nome,
        String telefone,
        String email,
        LocalDate dataNascimento,
        String cpf,
        EstadoCivilCliente estadoCivil,
        Long convenioId) {

    public DetalhesClienteDto(ClienteDb cliente) {
        this(
                cliente.getId(),
                cliente.getRg(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getDataNascimento(),
                cliente.getCpf(),
                cliente.getEstadoCivil(),
                cliente.getConvenioId());
    }
}
