package github.matheus_nicolau.core_clients.config;

import github.matheus_nicolau.core_clients.parse.ParseClientsDTOToClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfiguration {

    @Bean
    public ParseClientsDTOToClient parseClientsDTOToClient() {
        return new ParseClientsDTOToClient();
    }
}
