package br.com.fiap.economed.infrastructure.presentation.dto.convenio;

import java.time.LocalDate;

public record AtualizacaoConvenioDto(
        String nome,
        Double valor,
        String tipoServico,
        String cobertura,
        String contato,
        LocalDate validade) {
}
