package org.snowythinker.statemachine.exception;

@SuppressWarnings("serial")
public class OrderException extends ProcessException{

	public OrderException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderException(String message) {
		super(message);
	}
}
