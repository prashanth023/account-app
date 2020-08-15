package com.account.app.service;

import org.springframework.stereotype.Service;

import com.account.app.entity.Customer;
import com.account.app.exception.CustomerNotFoundException;
import com.account.app.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	
	public Customer findByCustomerId(final Integer id) {
		try {
		 return customerRepository.findById(id).get();
		}catch (Exception e) {

			throw new CustomerNotFoundException("Customer not found");
		}
	}
}
