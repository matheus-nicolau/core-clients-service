package github.matheus_nicolau.core_clients.repository;

import github.matheus_nicolau.core_clients.entity.Clients;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients, UUID> {
    Optional<Clients> findOneByEmail(String email);

    @Query("SELECT c FROM Clients c WHERE c.name IN ?1")
    Optional<List<Clients>> findAllByName(List<String> names);
}
