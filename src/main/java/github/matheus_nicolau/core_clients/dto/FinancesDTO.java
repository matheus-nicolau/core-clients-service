package github.matheus_nicolau.core_clients.dto;

import java.util.List;

public record FinancesDTO(
        List<ClientsDTO> clientList,
        List<CreditDTO> creditList
) { }
