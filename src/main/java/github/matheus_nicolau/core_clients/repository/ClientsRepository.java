package github.matheus_nicolau.core_clients.repository;

import github.matheus_nicolau.core_clients.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients, UUID> {

}
