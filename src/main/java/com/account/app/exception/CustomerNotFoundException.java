package com.account.app.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7666514566823450617L;

	public CustomerNotFoundException() {
		super();
	}
	
	public CustomerNotFoundException(final String message) {
		super(message);
	}
}
