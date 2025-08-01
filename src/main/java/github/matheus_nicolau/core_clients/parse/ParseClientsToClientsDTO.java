package github.matheus_nicolau.core_clients.parse;

import github.matheus_nicolau.core_clients.dto.ClientsDTO;
import github.matheus_nicolau.core_clients.entity.Clients;

import java.util.List;

public class ParseClientsToClientsDTO {

    public ClientsDTO parse(Clients client) {
        return new ClientsDTO(client.getName(), client.getEmail(), client.getCpf());
    }

    public List<ClientsDTO> parseAll(List<Clients> listOfClients) {
        return listOfClients.stream().map(client -> new ClientsDTO(client.getName(), client.getEmail(),
                                                                           client.getCpf())).toList();
    }
}
