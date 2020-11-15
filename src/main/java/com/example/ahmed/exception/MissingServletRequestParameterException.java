package com.example.ahmed.exception;

public class MissingServletRequestParameterException extends RuntimeException {

public MissingServletRequestParameterException(String message) {
	super(message);
}
}
