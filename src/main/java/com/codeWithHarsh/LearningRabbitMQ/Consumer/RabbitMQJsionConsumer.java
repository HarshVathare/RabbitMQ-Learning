package com.codeWithHarsh.LearningRabbitMQ.Consumer;

import com.codeWithHarsh.LearningRabbitMQ.DTO.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsionConsumer {

    @RabbitListener(queues = {"${rabbitmq.jsion.queue.name}"})
    public void JesionConsumer(User user) {
        log.info(String.format("Received Jsion message -> %s", user.toString()));
    }
}
