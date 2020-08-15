package com.account.app.exception;

public class AccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2239757543496826806L;

	public AccountNotFoundException() {
		
		super();
	}
	
	public AccountNotFoundException(final String message) {
		
		super(message);
	}
}
