package com.account.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -8144236940964443815L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "account_name ")
	private String accountName;

	@Column(name = "account_type")
	private Integer accountType;

	@Column(name = "market_cap")
	private Integer marketCap;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ACCOUNT_CUSTOMER", joinColumns = { @JoinColumn(name = "ACCOUNT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CUSTOMER_ID") })
	private List<Customer> customer;
	
}
