package br.com.fiap.economed.application.interfaces.gateways.dto.historicoHospitalCliente;

import br.com.fiap.economed.domain.entities.HistoricoHospitalCliente;

public record DetalhesHistoricoHospitalClienteDto(
        Long clienteId,
        String historicoMedico,
        String examesRealizados,
        String medicamentosPrescritos,
        String observacoes) {

    public DetalhesHistoricoHospitalClienteDto(HistoricoHospitalCliente historicoHospitalCliente) {
        this(
                historicoHospitalCliente.getClienteId(),
                historicoHospitalCliente.getHistoricoMedico(),
                historicoHospitalCliente.getExamesRealizados(),
                historicoHospitalCliente.getMedicamentosPrescritos(),
                historicoHospitalCliente.getObservacoes());
    }
}
