package br.com.fiap.economed.application.interfaces.gateways.dto.cliente;

import br.com.fiap.economed.domain.entities.Cliente;
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

    public DetalhesClienteDto(Cliente cliente) {
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
