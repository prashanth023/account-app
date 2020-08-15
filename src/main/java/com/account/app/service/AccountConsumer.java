package com.account.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.avro.generic.GenericData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.account.app.model.AccountDto;
import com.account.app.model.CustomerDto;
import com.account.app.repository.AccountRepository;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountConsumer {

	private final AccountRepository accountRepository;

	@KafkaListener(topics = "#{'${io.confluent.developer.config.topic.name}'}")
	public void consume(final ConsumerRecord<Long, GenericData.Record> consumerRecord) {

		log.info(consumerRecord.key() + "--" + consumerRecord.value() + "received {} { *********}$$$$$$$$$$$$$");
		GenericData.Record gerericData = consumerRecord.value();
		Gson gson = new Gson();
		log.info("converting json to object");
		AccountDto accountDto = gson.fromJson(gerericData.toString(), AccountDto.class);
		this.createAccount(accountDto);
		
	}

	private void createAccount(AccountDto account) {

		com.account.app.entity.Account accountEnt = new com.account.app.entity.Account();
		accountEnt.setAccountName(account.getAccountName());
		accountEnt.setAccountType(account.getAccountType());
		accountEnt.setMarketCap(account.getMarketCap());
		if (account.getCustomer() != null || account.getCustomer().isEmpty()) {

			List<CustomerDto> customers = account.getCustomer();
			List<com.account.app.entity.Customer> customersList = new ArrayList<com.account.app.entity.Customer>();
			Iterator<CustomerDto> customerIt = customers.iterator();
			while (customerIt.hasNext()) {

				CustomerDto customer = customerIt.next();
				com.account.app.entity.Customer customerEn = new com.account.app.entity.Customer();
				customerEn.setCustomerName(customer.getCustomerName());
				customerEn.setCustomerNum((Integer)customer.getCustomerNum().intValue());
				customersList.add(customerEn);
			}
			accountEnt.setCustomer(customersList);
		}
		accountRepository.save(accountEnt);
		log.info("Data saved.");

	}
}
