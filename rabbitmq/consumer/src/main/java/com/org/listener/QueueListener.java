package com.org.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @RabbitListener(queues = "queue")
    public void receive(String msg) {
        System.out.println("receive msg: " + msg);
    }
}
