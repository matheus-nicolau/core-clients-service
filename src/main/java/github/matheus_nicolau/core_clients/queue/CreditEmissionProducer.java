package github.matheus_nicolau.core_clients.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
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

    public void send(CreditDTO credit) throws Exception {
        String json = toJson(credit);
        rabbitTemplate.convertAndSend(queueEmission.getName(), json);
    }

    private String toJson(CreditDTO credit) {
        Gson gson = new Gson();
        return gson.toJson(credit);
    }

}
