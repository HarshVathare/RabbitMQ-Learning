package com.codeWithHarsh.LearningRabbitMQ.Publisher;

import com.codeWithHarsh.LearningRabbitMQ.DTO.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsionProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.jsion.routing.key}")
    private String jsionroutingKey;

//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJsionProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user) {
        log.info(String.format("Jsion Message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, jsionroutingKey, user);

    }
}
