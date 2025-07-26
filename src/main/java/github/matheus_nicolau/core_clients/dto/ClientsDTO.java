package github.matheus_nicolau.core_clients.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public record ClientsDTO(
        String name,
        @Email
        String email,
        @CPF
        String cpf
) {}
