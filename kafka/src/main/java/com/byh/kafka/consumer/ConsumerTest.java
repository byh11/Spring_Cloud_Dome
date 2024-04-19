package com.byh.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConsumerTest {

    public static void main(String[] args) {

        Map<String,Object> map=new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");


        KafkaConsumer<String,String> consumer=new KafkaConsumer<>(map);


        consumer.subscribe(Collections.singleton("test"));

        ConsumerRecords<String, String> poll = consumer.poll(100);

         for (ConsumerRecord<String, String> record : poll) {
             System.out.println(record);
         }

         consumer.close();

    }
}
