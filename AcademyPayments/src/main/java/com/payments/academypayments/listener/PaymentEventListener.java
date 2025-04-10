package com.payments.academypayments.listener;

import com.example.common.events.users.UserRegisteredEvent;
import com.payments.academypayments.configs.RabbitMQConfig;
import com.payments.academypayments.services.StripeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private StripeService stripeService;


    @RabbitListener(queues = RabbitMQConfig.USER_REGISTERED_QUEUE)
    public void userRegisteredEvent(UserRegisteredEvent event) {
        System.out.println("Event received: " + event);
        String url = stripeService.createSubscriptionLink("Gym Membership", 10000L, "brl");
        System.out.println("Payment link created: " + url);
    }

}
