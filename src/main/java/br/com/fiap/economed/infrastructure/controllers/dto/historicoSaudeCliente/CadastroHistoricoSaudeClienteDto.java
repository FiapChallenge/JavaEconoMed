package br.com.fiap.economed.infrastructure.controllers.dto.historicoSaudeCliente;

import java.time.LocalDate;

public record CadastroHistoricoSaudeClienteDto(
        Long clienteId,
        LocalDate dataRegistro,
        Boolean fuma,
        String doencaPrincipal,
        String historicoFamiliar,
        String alergias,
        String observacoes) {
}