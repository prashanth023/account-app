package com.account.app.exception;

public class AccountExsistedException extends Exception {

	private static final long serialVersionUID = -5872970681677504207L;

	public AccountExsistedException() {

		super();
	}

	public AccountExsistedException(final String message) {

		super(message);
	}
}
