package de.hegmanns.tdd.manaca;

public class AccountException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AccountException(String message) {
		super(message);
	}
}
