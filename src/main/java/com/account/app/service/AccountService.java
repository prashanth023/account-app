package com.account.app.service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.account.app.avro.Account;
import com.account.app.avro.Customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountService {

	private final KafkaTemplate<String, Account> producer;
	private final NewTopic topic;

	@EventListener(ApplicationStartedEvent.class)
	public void produce() throws InterruptedException, ExecutionException {

		final String key = "alice";
		final Account account = Account.newBuilder().setAccountName("hjkkk").setAccountType(2).setMarketCap(12223)
				.setCustomer(new ArrayList<Customer>()).build();
		ListenableFuture<SendResult<String, Account>> result = producer.send(topic.name(), key, account);
		log.info(" " + result.get().getProducerRecord().value());

		producer.flush();
		log.info(" messages were produced to topic {}", topic.name());

	}

}
