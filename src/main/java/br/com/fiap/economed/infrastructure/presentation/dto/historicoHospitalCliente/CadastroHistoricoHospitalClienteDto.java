package br.com.fiap.economed.infrastructure.presentation.dto.historicoHospitalCliente;

import java.time.LocalDate;

public record CadastroHistoricoHospitalClienteDto(
        Long clienteId,
        LocalDate dataRegistro,
        String historicoMedico,
        String examesRealizados,
        String medicamentosPrescritos,
        String observacoes) {
}