package github.matheus_nicolau.core_clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CoreClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreClientsApplication.class, args);
	}

}
