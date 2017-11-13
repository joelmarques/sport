package com.sport.campaign.api.exception;

public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = -4610205960407433811L;

	public NoContentException() {
		super("No content");
	}
}
