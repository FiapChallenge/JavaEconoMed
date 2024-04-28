package br.com.fiap.economed.infrastructure.controllers.dto.historicoHospitalCliente;

import br.com.fiap.economed.infrastructure.persistence.dbEntities.HistoricoHospitalClienteDb;

public record DetalhesHistoricoHospitalClienteDto(
        Long clienteId,
        String historicoMedico,
        String examesRealizados,
        String medicamentosPrescritos,
        String observacoes) {

    public DetalhesHistoricoHospitalClienteDto(HistoricoHospitalClienteDb historicoHospitalCliente) {
        this(
                historicoHospitalCliente.getClienteId(),
                historicoHospitalCliente.getHistoricoMedico(),
                historicoHospitalCliente.getExamesRealizados(),
                historicoHospitalCliente.getMedicamentosPrescritos(),
                historicoHospitalCliente.getObservacoes());
    }
}
