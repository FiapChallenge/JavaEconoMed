package br.com.fiap.economed.application.interfaces.gateways.dto.historicoHospitalCliente;

import java.time.LocalDate;

public record CadastroHistoricoHospitalClienteDto(
        Long clienteId,
        LocalDate dataRegistro,
        String historicoMedico,
        String examesRealizados,
        String medicamentosPrescritos,
        String observacoes) {
}