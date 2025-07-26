package github.matheus_nicolau.core_clients.services;

import github.matheus_nicolau.core_clients.dto.ClientsDTO;
import github.matheus_nicolau.core_clients.entity.Clients;
import github.matheus_nicolau.core_clients.exceptions.SaveClientException;
import github.matheus_nicolau.core_clients.parse.ParseClientsDTOToClient;
import github.matheus_nicolau.core_clients.repository.ClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;
    private final ParseClientsDTOToClient ClientsDTOToClient;

    public ClientsService(ClientsRepository repository, ParseClientsDTOToClient parse) {
        this.clientsRepository = repository;
        this.ClientsDTOToClient = parse;
    }

    public void createClients(ClientsDTO clientsDTO) {
        Clients client = ClientsDTOToClient.parse(clientsDTO);
        clientsRepository.save(client);
    }
}
