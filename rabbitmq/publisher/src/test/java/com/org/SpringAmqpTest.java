package com.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        while (true){

            rabbitTemplate.convertAndSend("queue", "hello world");
        }
    }

    @Test
    public void t1(){
        String exchange = "byh.fanout";
        String message = "hello world";
        rabbitTemplate.convertAndSend(exchange, "", message);
    }


    @Test
    public void t2(){
        String exchange = "byh.direct";
        rabbitTemplate.convertAndSend(exchange, "aa", "aa");
        rabbitTemplate.convertAndSend(exchange, "bb", "bb");
        rabbitTemplate.convertAndSend(exchange, "cc", "cc");
    }
}
