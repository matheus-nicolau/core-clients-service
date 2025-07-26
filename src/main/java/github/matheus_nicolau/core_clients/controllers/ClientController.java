package github.matheus_nicolau.core_clients.controllers;

import github.matheus_nicolau.core_clients.dto.ClientsDTO;
import github.matheus_nicolau.core_clients.services.ClientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientsService clientsService;

    public ClientController(ClientsService service) {
        this.clientsService = service;
    }

    @GetMapping("list/clients")
    public ResponseEntity<String> obtainClient() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<String> createClient(@RequestBody ClientsDTO client) {
        clientsService.createClients(client);
        return new ResponseEntity<>("Cliente salvo com sucesso !", HttpStatus.OK);
    }
}
