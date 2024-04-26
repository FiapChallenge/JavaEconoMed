package br.com.fiap.economed.application.interfaces.gateways.dto.historicoSaudeCliente;

import java.time.LocalDate;

public record AtualizacaoHistoricoSaudeClienteDto(
        LocalDate dataRegistro,
        Boolean fuma,
        String doencaPrincipal,
        String historicoFamiliar,
        String alergias,
        String observacoes
) {
}
