package github.matheus_nicolau.core_clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CoreClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreClientsApplication.class, args);
	}

}
