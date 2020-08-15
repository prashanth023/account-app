package com.account.app.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AccountDto {

	@NotNull
	private String accountName;
	
	@NotNull
	private Integer accountType;
	
	@NotNull
	private Integer marketCap;
	
	@Valid
	private List<CustomerDto> customer = null;
}