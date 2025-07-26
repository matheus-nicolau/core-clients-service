package github.matheus_nicolau.core_clients.dto;

import org.hibernate.validator.constraints.br.CPF;

public record ClientsDTO(
        String name,
        String email,
        @CPF
        String cpf
) {}
