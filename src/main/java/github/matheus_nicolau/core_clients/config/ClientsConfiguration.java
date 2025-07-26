package github.matheus_nicolau.core_clients.config;

import github.matheus_nicolau.core_clients.parse.ParseClientsDTOToClient;
import github.matheus_nicolau.core_clients.parse.ParseClientsToClientsDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfiguration {

    @Bean
    public ParseClientsDTOToClient parseClientsDTOToClient() {
        return new ParseClientsDTOToClient();
    }

    @Bean
    public ParseClientsToClientsDTO parseClientsToClientDTO() {
        return new ParseClientsToClientsDTO();
    }
}
