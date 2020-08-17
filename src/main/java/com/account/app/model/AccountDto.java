package com.account.app.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AccountDto {

	@NotNull
	private String accountName;
	
	@NotNull
	@Min(value=1)
	@Max(value=2)
	private Integer accountType;
	
	@NotNull
	private Integer marketCap;
	
	@Valid
	private List<CustomerDto> customer = null;
}