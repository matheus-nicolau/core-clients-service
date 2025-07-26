package github.matheus_nicolau.core_clients.controllers;

import github.matheus_nicolau.core_clients.dto.ClientsDTO;
import github.matheus_nicolau.core_clients.services.ClientsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientsService clientsService;

    public ClientController(ClientsService service) {
        this.clientsService = service;
    }

    @GetMapping("{email}")
    public ResponseEntity<ClientsDTO> listClient(@PathVariable String email) {
        var uniqueClient = clientsService.getOneClient(email);
        return new ResponseEntity<>(uniqueClient, HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<ClientsDTO>> listClient() {
        var listOfClients = clientsService.getAllClients();
        return new ResponseEntity<>(listOfClients, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientsDTO client) {
        clientsService.createClients(client);
        return new ResponseEntity<>("Cliente salvo com sucesso !", HttpStatus.OK);
    }

    @DeleteMapping("remove/{email}")
    public ResponseEntity<String> removeClient(@PathVariable String email) {
        clientsService.removeOneClient(email);
        return new ResponseEntity<>("Cliente removido com sucesso !", HttpStatus.OK);
    }
}
