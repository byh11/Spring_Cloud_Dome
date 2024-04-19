package com.byh.kafka.admin;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KafkaAdmin {

    public static void main(String[] args) {

        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        Admin admin = Admin.create(configs);

        NewTopic topic = new NewTopic("test1", 1, (short) 1);
        NewTopic topic2 = new NewTopic("test2", 2, (short) 2);
        CreateTopicsResult topics = admin.createTopics(
                Arrays.asList(topic, topic2)
        );
        admin.close();
    }
}
