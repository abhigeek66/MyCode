package com.example.demo.exception;

public class CustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomRuntimeException(String message) {
		super(message);
	}

	public CustomRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
