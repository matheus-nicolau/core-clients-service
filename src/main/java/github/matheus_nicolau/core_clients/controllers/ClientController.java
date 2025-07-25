package github.matheus_nicolau.core_clients.controllers;

import github.matheus_nicolau.core_clients.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("obtain-clients")
    public ResponseEntity<String> obtainClient() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<String> saveClient(ClientDTO client) {
        if (null == client) return new ResponseEntity<>("Erro ao salvar cliente", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Cliente salvo com sucesso !", HttpStatus.OK);
    }
}
