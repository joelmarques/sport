package com.sport.customer.api.exception;

public class DuplicateRegistrationException extends RuntimeException {

	private static final long serialVersionUID = -4610205960407433811L;

	public DuplicateRegistrationException() {
		super("Duplicate registration");
	}
}
