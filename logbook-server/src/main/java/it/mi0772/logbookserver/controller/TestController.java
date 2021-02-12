package it.mi0772.logbookserver.controller;

import it.mi0772.logbookserver.configuration.RabbitMQDefaultConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final RabbitTemplate rabbitTemplate;

    public TestController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitMQDefaultConfiguration.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        return "ok";
    }
}
