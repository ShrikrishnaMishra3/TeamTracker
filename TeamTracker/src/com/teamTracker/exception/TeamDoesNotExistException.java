package com.teamTracker.exception;


@SuppressWarnings("serial")
public class TeamDoesNotExistException extends RuntimeException {
	public static String message = "team does not exists !..please login";

	public TeamDoesNotExistException() {

	}

	@SuppressWarnings("static-access")
	public TeamDoesNotExistException(String message) {
		this.message = message;
	}
}
