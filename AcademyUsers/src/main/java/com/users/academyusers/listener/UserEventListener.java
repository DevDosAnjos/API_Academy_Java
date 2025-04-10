package com.users.academyusers.listener;

import com.example.common.events.users.UserUpdatedEvent;
import com.users.academyusers.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @RabbitListener(queues = RabbitMQConfig.USER_UPDATED_QUEUE)
    public void userUpdateEvent(UserUpdatedEvent event){
        System.out.println("Processing event of update: " + event);
    }

}
