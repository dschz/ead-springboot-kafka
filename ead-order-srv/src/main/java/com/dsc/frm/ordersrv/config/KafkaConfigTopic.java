package com.dsc.frm.ordersrv.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * spring va creer le topic kafka quand le serveur va demarrer
 *
 * @author DSchneider
 */
@Configuration
public class KafkaConfigTopic {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName).build();
    }
}
