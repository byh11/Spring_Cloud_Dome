package com.byh.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

public class ProducerInterceptor {

    public static void main(String[] args) {

        //配置参数
        Map<String,Object> map=new HashMap<String,Object>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        map.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,ValueInterceptorTest.class.getName());

        //创建生产者
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(map);

        //发送消息
//        ProducerRecord<String,String> record = new ProducerRecord<String,String>("test","k1","hello kafka");

        for (int i = 0; i < 10; i++) {
            ProducerRecord record = new ProducerRecord<String,String>("test1","k"+i,"hello kafka"+i);
            producer.send(record);
        }


        producer.close();

    }
}
