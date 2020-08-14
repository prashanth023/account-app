package com.account.app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource({"classpath:kafka.properties"})
@Component
public class KafkaConfig {
	
	@Value("${io.confluent.developer.config.topic.name}")
	private String topicName;

	@Value("${io.confluent.developer.config.topic.partitions}")
	private int numPartitions;

	@Value("${io.confluent.developer.config.topic.replicas}")
	private int replicas;

	@Bean
	NewTopic accountTopic() {
		return new NewTopic(topicName, numPartitions, (short) replicas);
	}

}
