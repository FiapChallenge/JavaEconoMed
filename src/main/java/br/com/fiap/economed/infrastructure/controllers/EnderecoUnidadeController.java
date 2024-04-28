package br.com.fiap.economed.infrastructure.controllers;

import br.com.fiap.economed.infrastructure.controllers.dto.unidadeEndereco.AtualizacaoEnderecoUnidadeDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.economed.infrastructure.controllers.dto.unidadeEndereco.CadastroEnderecoUnidadeDto;
import br.com.fiap.economed.infrastructure.controllers.dto.unidadeEndereco.DetalhesEnderecoUnidadeDto;
import br.com.fiap.economed.infrastructure.persistence.dbEntities.EnderecoUnidadeDb;
import br.com.fiap.economed.infrastructure.persistence.repositories.EnderecoUnidadeRepository;

@RestController
@RequestMapping("/unidades")
public class EnderecoUnidadeController {

    @Autowired
    private EnderecoUnidadeRepository enderecoRepository;

    @GetMapping("/{unidadeId}/endereco")
    public ResponseEntity<DetalhesEnderecoUnidadeDto> buscar(@PathVariable("unidadeId") Long unidadeId) throws EntityNotFoundException {
        var endereco = enderecoRepository.findByUnidadeId(unidadeId)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(new DetalhesEnderecoUnidadeDto(endereco));
    }

    @PostMapping("/endereco")
    @Transactional
    public ResponseEntity<DetalhesEnderecoUnidadeDto> cadastrar(@RequestBody CadastroEnderecoUnidadeDto enderecoDto,
            UriComponentsBuilder uriBuilder) {
        var endereco = new EnderecoUnidadeDb(enderecoDto);
        enderecoRepository.save(endereco);
        var uri = uriBuilder.path("unidades/{unidadeID}/endereco").buildAndExpand(endereco.getUnidadeId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEnderecoUnidadeDto(endereco));
    }

    @PutMapping("/{unidadeId}/endereco")
    @Transactional
    public ResponseEntity<DetalhesEnderecoUnidadeDto> atualizar(@PathVariable("unidadeId") Long unidadeId,
            @RequestBody AtualizacaoEnderecoUnidadeDto enderecoDto) throws EntityNotFoundException {
        var endereco = enderecoRepository.findByUnidadeId(unidadeId)
                .orElseThrow(EntityNotFoundException::new);
        endereco.atualizarDados(enderecoDto);
        return ResponseEntity.ok(new DetalhesEnderecoUnidadeDto(endereco));
    }
}
