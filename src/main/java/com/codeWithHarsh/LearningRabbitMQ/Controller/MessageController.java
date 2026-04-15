package com.codeWithHarsh.LearningRabbitMQ.Controller;

import com.codeWithHarsh.LearningRabbitMQ.DTO.User;
import com.codeWithHarsh.LearningRabbitMQ.Publisher.RabbitMQJsionProducer;
import com.codeWithHarsh.LearningRabbitMQ.Publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitMQProducer producer;

    private final RabbitMQJsionProducer jsionProducer;

    public MessageController(RabbitMQProducer producer, RabbitMQJsionProducer jsionProducer) {
        this.producer = producer;
        this.jsionProducer = jsionProducer;
    }

    //http://localhost:8080/api/v1/publish?message=
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent in RabbitMQ Server ...!");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsionMessage(@RequestBody User user) {
        jsionProducer.sendMessage(user);
        return ResponseEntity.ok("Jsion message sent in RabbitMQ ....!");
    }
}
