package github.matheus_nicolau.core_clients.parse;

import github.matheus_nicolau.core_clients.dto.ClientsDTO;
import github.matheus_nicolau.core_clients.entity.Clients;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ParseClientsDTOToClient {

    public Clients parse(ClientsDTO clientsDTO) {
        String cpf = clientsDTO.cpf().replaceAll("[^0-9]", "");
        return new Clients(clientsDTO.name(), clientsDTO.email(), cpf, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}