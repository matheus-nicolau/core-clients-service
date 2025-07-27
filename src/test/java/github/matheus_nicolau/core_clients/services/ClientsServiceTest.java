package github.matheus_nicolau.core_clients.services;

import github.matheus_nicolau.core_clients.dto.ClientsDTO;
import github.matheus_nicolau.core_clients.entity.Clients;
import github.matheus_nicolau.core_clients.exceptions.ClientNotFindException;
import github.matheus_nicolau.core_clients.exceptions.SaveClientException;
import github.matheus_nicolau.core_clients.parse.ParseClientsDTOToClient;
import github.matheus_nicolau.core_clients.parse.ParseClientsToClientsDTO;
import github.matheus_nicolau.core_clients.repository.ClientsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ClientsServiceTest {

    @Mock
    Clients client;
    @Mock
    ClientsDTO clientsDTO;
    @Mock
    ClientsRepository clientsRepository;

    @InjectMocks
    ClientsService clientsService;

    @Test
    @DisplayName("Must be validate if does not throws any exception")
    void givenHaveAClient_whenTrySaveTheClient_thenDoesNotThrowsAnyException() {
        // GIVEN
        given(clientsDTO.email()).willReturn("");

        // WHEN
        assertDoesNotThrow(() -> {
            clientsService.createClients(clientsDTO);
        });
    }

    @Test
    @DisplayName("Must be validate if throws a SaveClientException")
    void givenHaveAClient_whenTrySaveTheClient_thenThrowsSaveClientException() {
        // GIVEN
        given(clientsDTO.email()).willReturn("");
        given(clientsRepository.findOneByEmail("")).willReturn(Optional.of(client));

        // WHEN
        assertThrows(SaveClientException.class, () -> {
            clientsService.createClients(clientsDTO);
        });
    }

    @Test
    @DisplayName("Must be return a client if exists")
    void givenHaveAEmail_whenTryFindAClient_thenReturnAClient() {
        // GIVEN
        given(clientsRepository.findOneByEmail("")).willReturn(Optional.of(client));

        // WHEN
        assertDoesNotThrow(() -> {
            clientsService.getOneClient("");
        });
    }

    @Test
    @DisplayName("Must be validate if throws a ClientNotFindException in getOneClient()")
    void givenHaveAEmail_whenTryFindAClient_thenReturnAClientNotFindException() {
        // GIVEN
        given(clientsRepository.findOneByEmail("")).willReturn(Optional.empty());

        // WHEN
        assertThrows(ClientNotFindException.class, () -> {
            clientsService.getOneClient("");
        });
    }

    @Test
    @DisplayName("Must be validate if return a empty list of clientsDTO")
    void givenWantToSearch_whenTryFindAListOfClient_thenReturnAEmptyListOfClientsDTO() {
        // WHEN
        List<ClientsDTO> allClients = clientsService.getAllClients();

        // THEN
        assertEquals(0, allClients.size());
    }

    @Test
    @DisplayName("Must be validate if delete a client")
    void givenWantToDeleteAClient_whenTryFindThisClient_thenDoNotThrowsAException() {
        // GIVEN
        given(clientsRepository.findOneByEmail("")).willReturn(Optional.of(client));

        // WHEN
        assertDoesNotThrow(() -> {
            clientsService.removeOneClient("");
        });
    }

    @Test
    @DisplayName("Must be validate if throws a ClientNotFindException in removeOneClient()")
    void givenWantToDeleteAClient_whenTryFindThisClient_thenThrowsAClientNotFindException() {
        // GIVEN
        given(clientsRepository.findOneByEmail("")).willReturn(Optional.empty());

        // WHEN
        assertThrows(ClientNotFindException.class, () -> {
            clientsService.removeOneClient("");
        });
    }
}