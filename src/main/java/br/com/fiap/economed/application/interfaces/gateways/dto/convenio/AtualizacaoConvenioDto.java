package br.com.fiap.economed.application.interfaces.gateways.dto.convenio;

import java.time.LocalDate;

public record AtualizacaoConvenioDto(
        String nome,
        Double valor,
        String tipoServico,
        String cobertura,
        String contato,
        LocalDate validade) {
}
