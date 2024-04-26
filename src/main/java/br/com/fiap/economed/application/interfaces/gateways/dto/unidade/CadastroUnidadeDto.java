package br.com.fiap.economed.application.interfaces.gateways.dto.unidade;


public record CadastroUnidadeDto(
        Long empresaId,
        String nome,
        String telefone,
        String email,
        String tipo,
        Integer capacidade,
        String especialidades) {

}
