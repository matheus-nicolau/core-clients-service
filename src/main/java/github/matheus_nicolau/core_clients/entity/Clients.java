package github.matheus_nicolau.core_clients.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private ZonedDateTime createdAt;

    @Deprecated
    Clients() {}

    public Clients(String name, String email, String cpf,  ZonedDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.createdAt = createdAt;
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

    public String getCpf() {
        return cpf;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(id, clients.id) && Objects.equals(name, clients.name)
                && Objects.equals(email, clients.email) && Objects.equals(cpf, clients.cpf)
                && Objects.equals(createdAt, clients.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, cpf, createdAt);
    }
}
