package com.databasegroup.exception;

public class NoEnoughBooksException extends RuntimeException {
	
	public NoEnoughBooksException() {
	}
	
	public NoEnoughBooksException(String message) {
		super(message);
	}
}
