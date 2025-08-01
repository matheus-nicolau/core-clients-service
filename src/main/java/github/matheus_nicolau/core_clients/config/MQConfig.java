package github.matheus_nicolau.core_clients.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.credit-emission}")
    private String queueName;

    @Bean
    public Queue queueEmission() {
        return new Queue(queueName, true);
    }


}
