package com.teamTracker.exception;



@SuppressWarnings("serial")
public class TeamAlreadyExistException extends RuntimeException {
	public static String message = "team already exists !..please login";

	public TeamAlreadyExistException() {

	}

	@SuppressWarnings("static-access")
	public TeamAlreadyExistException(String message) {
		this.message = message;
	}
}
