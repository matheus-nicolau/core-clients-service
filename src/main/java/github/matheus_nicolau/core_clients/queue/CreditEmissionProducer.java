package github.matheus_nicolau.core_clients.queue;

import github.matheus_nicolau.core_clients.dto.CreditDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreditEmissionProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueEmission;

    public CreditEmissionProducer(RabbitTemplate rabbitTemplate, Queue queueEmission) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueEmission = queueEmission;
    }

    public void send(CreditDTO credit) {

        System.out.println("Sending message: ");
    }

}
