package br.com.fiap.economed.application.config;

import br.com.fiap.economed.application.gateways.ClienteGateway;
import br.com.fiap.economed.application.usecases.cliente.ClienteInteractor;
import br.com.fiap.economed.infrastructure.controllers.dto.cliente.ClienteDTOMapper;
import br.com.fiap.economed.infrastructure.gateways.ClienteRepositoryGateway;
import br.com.fiap.economed.infrastructure.gateways.mappers.ClienteMapper;
import br.com.fiap.economed.infrastructure.persistence.repositories.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {
    @Bean
    ClienteInteractor createClienteCase(ClienteGateway clienteGateway) {
        return new ClienteInteractor(clienteGateway);
    }

    @Bean
    ClienteGateway clienteGateway(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        return new ClienteRepositoryGateway(clienteRepository, clienteMapper);
    }

    @Bean
    ClienteMapper clienteMapper() {
        return new ClienteMapper();
    }

    @Bean
    ClienteDTOMapper clienteDTOMapper() {
        return new ClienteDTOMapper();
    }

}
