package com.account.app.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Account_type")
public class AccountType implements Serializable {

	private static final long serialVersionUID = 1896067765949928210L;

	@Id
	private int id;

	@Column(name = "Account_type")
	private String accountTyp;

}
