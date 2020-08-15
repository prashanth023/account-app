package com.account.app.exception;

public class AccountServiceException extends RuntimeException {

	private static final long serialVersionUID = -7249599519673171681L;

	public AccountServiceException() {

		super();
	}

	public AccountServiceException(final String message) {

		super(message);
	}
}
