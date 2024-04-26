package br.com.fiap.economed.application.interfaces.gateways.dto.convenio;

import br.com.fiap.economed.domain.entities.Convenio;

import java.time.LocalDate;

public record DetalhesConvenioDto(
        Long id,
        Long empresaId,
        String nome,
        Double valor,
        String tipoServico,
        String cobertura,
        String contato,
        LocalDate validade) {

    public DetalhesConvenioDto(Convenio convenio) {
        this(
                convenio.getId(),
                convenio.getEmpresaId(),
                convenio.getNome(),
                convenio.getValor(),
                convenio.getTipoServico(),
                convenio.getCobertura(),
                convenio.getContato(),
                convenio.getValidade());
    }
}
