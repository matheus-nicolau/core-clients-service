package github.matheus_nicolau.core_clients.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final UUID id;
    private final String name;
    private final String email;
    private final Integer cpf;

    public Clients(UUID id, String name, String email, Integer cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(id, clients.id) && Objects.equals(name, clients.name)
                && Objects.equals(email, clients.email) && Objects.equals(cpf, clients.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, cpf);
    }
}
