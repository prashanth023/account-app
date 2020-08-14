package com.account.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class AccountCustomerId implements Serializable{

	private static final long serialVersionUID = -4971920053541953639L;

	@Column(name="ACCOUNT_ID")
	private Integer accountId;
	
	@Column(name="CUSTOMER_ID")
	private Integer customerId;
}
