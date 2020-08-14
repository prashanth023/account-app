package com.account.app.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ACCOUNT_CUSTOMER")
public class AccountCustomer {

	@EmbeddedId
	private AccountCustomerId accountCustomerId;
}
