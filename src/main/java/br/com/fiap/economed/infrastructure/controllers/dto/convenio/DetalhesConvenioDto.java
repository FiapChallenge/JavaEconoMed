package br.com.fiap.economed.infrastructure.controllers.dto.convenio;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.ConvenioDb;

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

    public DetalhesConvenioDto(ConvenioDb convenio) {
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
