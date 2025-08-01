package github.matheus_nicolau.core_clients.services;

import github.matheus_nicolau.core_clients.dto.ClientsDTO;
import github.matheus_nicolau.core_clients.dto.CreditDTO;
import github.matheus_nicolau.core_clients.dto.FinancesDTO;
import github.matheus_nicolau.core_clients.entity.Clients;
import github.matheus_nicolau.core_clients.exceptions.ClientNotFindException;
import github.matheus_nicolau.core_clients.exceptions.ExceptionMessages;
import github.matheus_nicolau.core_clients.exceptions.SaveClientException;
import github.matheus_nicolau.core_clients.parse.ParseClientsDTOToClient;
import github.matheus_nicolau.core_clients.parse.ParseClientsToClientsDTO;
import github.matheus_nicolau.core_clients.repository.ClientsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    private final ClientCredit clientCredit;
    private final ClientsRepository clientsRepository;
    private final ParseClientsDTOToClient clientsDTOToClient;
    private final ParseClientsToClientsDTO clientsToClientsDTO;

    public ClientsService(ClientsRepository clientsRepository, ParseClientsDTOToClient clientsDTOToClient,
                          ParseClientsToClientsDTO clientsToClientsDTO, ClientCredit clientCredit) {
        this.clientsRepository = clientsRepository;
        this.clientsDTOToClient = clientsDTOToClient;
        this.clientsToClientsDTO = clientsToClientsDTO;
        this.clientCredit = clientCredit;
    }

    public void createClients(ClientsDTO clientsDTO) {
        Optional<Clients> oneByEmail = clientsRepository.findOneByEmail(clientsDTO.email());
        if (oneByEmail.isPresent()) throw new SaveClientException(ExceptionMessages.CLIENT_ALREADY_EXISTS.message());
        Clients client = clientsDTOToClient.parse(clientsDTO);
        clientsRepository.save(client);
    }

    public ClientsDTO getOneClient(String email) {
        Optional<Clients> clientsOptional = clientsRepository.findOneByEmail(email);
        Clients clientModify = clientsOptional.orElseThrow(() -> new ClientNotFindException(
                                                                    ExceptionMessages.CLIENT_NOT_FINDED.message()));
        return clientsToClientsDTO.parse(clientModify);
    }

    public List<ClientsDTO> getAllClients() {
        List<Clients> clientList = clientsRepository.findAll();
        return clientsToClientsDTO.parseAll(clientList);
    }

    public void removeOneClient(String email) {
        Optional<Clients> clientsOptional = clientsRepository.findOneByEmail(email);
        Clients clientToDelete = clientsOptional.orElseThrow(() -> new ClientNotFindException(
                                                                        ExceptionMessages.CLIENT_NOT_FINDED.message()));
        clientsRepository.delete(clientToDelete);
    }

    public FinancesDTO testFeing(String limit) {
        List<CreditDTO> creditList = clientCredit.listByLimit(limit).getBody();
        List<String> names = new ArrayList<>();
        if (null != creditList) names = creditList.stream().map(CreditDTO::name).toList();
        List<Clients> findedList = clientsRepository.findAllByName(names).orElseThrow(() -> new ClientNotFindException(
                                                                        ExceptionMessages.CLIENT_NOT_FINDED.message()));
        List<ClientsDTO> clientsList = clientsToClientsDTO.parseAll(findedList);

        return new FinancesDTO(clientsList, creditList);
    }
}
