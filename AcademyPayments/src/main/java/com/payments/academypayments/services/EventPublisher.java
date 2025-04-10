package com.payments.academypayments.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public <T> void publishEvent(String exchange, String routingKey, T event) {
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
        System.out.println("Event publish: " + event.getClass().getSimpleName() + " -> " + event);
    }
}
