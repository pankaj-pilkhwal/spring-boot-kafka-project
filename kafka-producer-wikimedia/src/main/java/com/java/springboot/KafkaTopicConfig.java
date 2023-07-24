package com.java.springboot;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("wikimedia_recentchange").build();

        // to read real time stream data from wikimedia, we use event source.



    }
}
