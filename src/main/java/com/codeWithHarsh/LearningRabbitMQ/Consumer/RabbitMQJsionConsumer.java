package com.codeWithHarsh.LearningRabbitMQ.Consumer;

import com.codeWithHarsh.LearningRabbitMQ.DTO.User;
import com.codeWithHarsh.LearningRabbitMQ.EmailService.MailgunEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsionConsumer {

    private final MailgunEmailService emailService;

    public RabbitMQJsionConsumer(MailgunEmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = {"${rabbitmq.jsion.queue.name}"})
    public void JesionConsumer(User user) {
        log.info(String.format("Received Jsion message -> %s", user.toString()));

        // 🔥 Send Email
        emailService.sendEmail(
                user.getEmail(),
                "Welcome to Our System 🚀",
                "Hello " + user.getFirstName() + " "+user.getLastName()+", your registration is successful!"
        );
    }
}
