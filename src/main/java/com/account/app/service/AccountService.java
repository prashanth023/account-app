package com.account.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.account.app.avro.Account;
import com.account.app.avro.Customer;
import com.account.app.exception.AccountExsistedException;
import com.account.app.exception.AccountNotFoundException;
import com.account.app.exception.AccountServiceException;
import com.account.app.model.AccountDto;
import com.account.app.model.CustomerDto;
import com.account.app.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountService {

	private final KafkaTemplate<String, Account> producer;
	private final NewTopic topic;
	private final AccountRepository accountRepository;

	// @EventListener(ApplicationStartedEvent.class)
	public String produce(AccountDto accDto) throws InterruptedException, ExecutionException {

		final String key = "account";
		
		if(findByAccount(accDto.getAccountName(),accDto.getAccountType())==true) {
			
			return "Account already existed";
		}
		
		List<CustomerDto> customerDtos=accDto.getCustomer() ;
		List<Customer> customers=new ArrayList<Customer>();
		if(customerDtos!= null) {
			
			Iterator<CustomerDto> it=customerDtos.iterator();
			while(it.hasNext()) {
				
				CustomerDto cDt=it.next();
				Customer customer=Customer.newBuilder()
						.setCustomerName(cDt.getCustomerName())
						.setCustomerNum(cDt.getCustomerNum())
						.build();
				customers.add(customer);
			}
		}

		final Account account = Account.newBuilder()
				.setAccountName(accDto.getAccountName())
				.setAccountType(accDto.getAccountType())
				.setMarketCap(accDto.getMarketCap())
				.setCustomer(customers)
				.build();
		
		ListenableFuture<SendResult<String, Account>> result = producer.send(topic.name(), key, account);
		log.info(" " + result.get().getProducerRecord().value());

		producer.flush();
		log.info(" messages were produced to topic {}", topic.name());
		return "account created";
	}

	public List<com.account.app.entity.Account> findAllAccount() {

		List<com.account.app.entity.Account> accounts = null;
		try {

			accounts = accountRepository.findAll();

			if (accounts.isEmpty()) {

				throw new AccountNotFoundException("Account not found");
			}

		} catch (AccountServiceException e) {

			throw new AccountServiceException("Internal  server error");
		}

		return accounts;
	}

	public com.account.app.entity.Account findAccountByName(final String accountName) {

		com.account.app.entity.Account account = null;

		try {

			account = accountRepository.findByAccountName(accountName);
			if (account == null) {

				throw new AccountNotFoundException("Account not found");
			}

		} catch (AccountServiceException e) {

			throw new AccountServiceException("Internal  server error");
		}

		return account;
	}

	public String addAccount(com.account.app.entity.Account account) throws AccountExsistedException {

		String status = null;

		try {

			accountRepository.save(account);
			status = "Account created";

		} catch (Exception e) {

			throw new AccountExsistedException("Account already existed");
		}

		return status;
	}

	public boolean findByAccount(String accountName,Integer type) {
		
		boolean status=false;
		com.account.app.entity.Account account=accountRepository.findByAccountNameAndAccountType(accountName, type);
		if(account!=null) {
			status=true;
		}
		return status;
		
	}
}
