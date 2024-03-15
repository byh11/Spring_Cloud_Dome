package com.org.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

//    @RabbitListener(queues = "queue")
//    public void receive(String msg) {
//        System.out.println("receive msg: " + msg);
//    }


    @RabbitListener(queues = "fanout.queue1")
    public void receive(String msg) {
        System.out.println("fanout.queue1 msg: " + msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void receive2(String msg) {
        System.out.println("fanout.queue2 msg: " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("direct.queue1"), exchange = @Exchange(name = "byh.direct", type = "direct"), key = {"aa", "bb"}))
    public void receive3(String msg) {
        System.out.println("direct.queue1 msg: " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("direct.queue2"), exchange = @Exchange(name = "byh.direct", type = "direct"), key = {"aa", "cc"}))
    public void receive4(String msg) {
        System.out.println("direct.queue2 msg: " + msg);
    }
}
