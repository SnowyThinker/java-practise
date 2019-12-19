package org.snowythinker.statemachine.exception;

@SuppressWarnings("serial")
public class PaymentException extends ProcessException{

	public PaymentException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentException(String message) {
		super(message);
	}
}
