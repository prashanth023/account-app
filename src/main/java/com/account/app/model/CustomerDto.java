package com.account.app.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomerDto {

	@NotNull
	private String customerName;
	@NotNull
	private Long customerNum;
}
