package br.com.fiap.economed.infrastructure.controllers;

import br.com.fiap.economed.infrastructure.controllers.dto.cliente.*;
import br.com.fiap.economed.application.usecases.cliente.ClienteInteractor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.fiap.economed.infrastructure.controllers.dto.cliente.create.CreateClienteRequest;
import br.com.fiap.economed.infrastructure.controllers.dto.cliente.create.CreateClienteResponse;
import br.com.fiap.economed.infrastructure.controllers.dto.cliente.list.ListClienteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteInteractor clienteInteractor;
    private final ClienteDTOMapper clienteDTOMapper;

    public ClienteController(ClienteInteractor clienteInteractor, ClienteDTOMapper clienteDTOMapper) {
        this.clienteInteractor = clienteInteractor;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    @GetMapping
    public ResponseEntity<List<ListClienteResponse>> listarClientes() {
        try {
            List<ListClienteResponse> clientes = clienteInteractor.listAll().stream()
                    .map(clienteDTOMapper::toListResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(clientes);
        } catch (Exception ex) {
            throw new RuntimeException("Falha ao listar clientes", ex);
        }
    }

//
//    @GetMapping("/{clienteId}")
//    public ResponseEntity<DetalhesClienteDto> buscar(@PathVariable("clienteId") Long clienteId)
//            throws EntityNotFoundException {
//        var cliente = createClienteInteractor.findById(clienteId).orElseThrow(EntityNotFoundException::new);
//        return ResponseEntity.ok(new DetalhesClienteDto(cliente));
//    }

    @PostMapping
    @Transactional
    public ResponseEntity<CreateClienteResponse> criarCliente(@RequestBody CreateClienteRequest request,
                                                              UriComponentsBuilder uri) {
        try {
            var cliente = clienteDTOMapper.toCliente(request);
            var clienteCriado = clienteInteractor.create(cliente);
            var uriCliente = uri.path("/clientes/{clienteId}").buildAndExpand(clienteCriado.id()).toUri();
            return ResponseEntity.created(uriCliente).body(clienteDTOMapper.toResponse(clienteCriado));
        } catch (Exception ex) {
            throw new RuntimeException("Falha ao criar cliente", ex);
        }
    }


//    @PutMapping("/{clienteId}")
//    @Transactional
//    public ResponseEntity<DetalhesClienteDto> atualizar(@PathVariable("clienteId") Long clienteId,
//            @RequestBody AtualizacaoClienteDto clienteDto) throws EntityNotFoundException {
//        var cliente = createClienteInteractor.findById(clienteId).orElseThrow(EntityNotFoundException::new);
//        cliente.atualizarDados(clienteDto);
//        return ResponseEntity.ok(new DetalhesClienteDto(cliente));
//    }
//
//    @DeleteMapping("/{clienteId}")
//    @Transactional
//    public ResponseEntity<Void> remover(@PathVariable("clienteId") Long clienteId) throws EntityNotFoundException {
//        var cliente = createClienteInteractor.findById(clienteId).orElseThrow(EntityNotFoundException::new);
//        createClienteInteractor.delete(cliente);
//        return ResponseEntity.noContent().build();
//    }

}
