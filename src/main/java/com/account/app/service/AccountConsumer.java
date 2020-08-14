package com.account.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.account.app.avro.Account;
import com.account.app.avro.Customer;
import com.account.app.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountConsumer {
	
	private final AccountRepository accountRepository;

  @KafkaListener(topics = "#{'${io.confluent.developer.config.topic.name}'}")
  public void consume(final ConsumerRecord<Long, Account> consumerRecord) {
	  
    log.info("received {} {}", consumerRecord.key(), consumerRecord.value());
    Account account=consumerRecord.value();
    com.account.app.entity.Account accountEnt= new com.account.app.entity.Account();
    accountEnt.setAccountName(account.getAccountName());
    accountEnt.setAccountType(account.getAccountType());
    accountEnt.setMarketCap(account.getMarketCap());
   if(account.getCustomer() != null && account.getCustomer().isEmpty()) {
	   
	  List<Customer> customers=account.getCustomer();
	  List<com.account.app.entity.Customer> customersList=new ArrayList<com.account.app.entity.Customer>();
	  Iterator<Customer> customerIt=customers.iterator();
	  while(customerIt.hasNext()) {
		  
		 Customer customer= customerIt.next();
		 com.account.app.entity.Customer customerEn=new com.account.app.entity.Customer();
		 customerEn.setCustomerName(customer.getCustomerName());
		 customerEn.setCustomerNum((int)customer.getCustomerNum());
		 customersList.add(customerEn);
	  }
	  accountEnt.setCustomer(customersList);
   }
   accountRepository.save(accountEnt);
   log.info("Data saved.");
  }
}
