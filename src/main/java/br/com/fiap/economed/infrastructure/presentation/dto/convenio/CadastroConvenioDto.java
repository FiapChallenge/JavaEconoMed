package br.com.fiap.economed.infrastructure.presentation.dto.convenio;

import java.time.LocalDate;

public record CadastroConvenioDto(
                String nome,
                Long empresaId,
                Double valor,
                String tipoServico,
                String cobertura,
                String contato,
                LocalDate validade) {

}
