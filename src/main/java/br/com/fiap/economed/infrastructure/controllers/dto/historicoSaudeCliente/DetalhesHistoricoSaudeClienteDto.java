package br.com.fiap.economed.infrastructure.controllers.dto.historicoSaudeCliente;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.HistoricoSaudeClienteDb;

public record DetalhesHistoricoSaudeClienteDto(
        Long id,
        Long clienteId,
        Boolean fuma,
        String doencaPrincipal,
        String historicoFamiliar,
        String alergias,
        String observacoes) {

    public DetalhesHistoricoSaudeClienteDto(HistoricoSaudeClienteDb historicoSaudeCliente) {
        this(
                historicoSaudeCliente.getId(),
                historicoSaudeCliente.getClienteId(),
                historicoSaudeCliente.getFuma(),
                historicoSaudeCliente.getDoencaPrincipal(),
                historicoSaudeCliente.getHistoricoFamiliar(),
                historicoSaudeCliente.getAlergias(),
                historicoSaudeCliente.getObservacoes());
    }
}
