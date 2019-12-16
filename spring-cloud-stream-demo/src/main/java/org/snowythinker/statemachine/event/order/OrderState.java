package org.snowythinker.statemachine.event.order;

import org.snowythinker.statemachine.event.ProcessState;


/**  
 * DEFAULT    -  submit -> orderProcessor()   -> orderCreated   -> PMTPENDING
 * PMTPENDING -  pay    -> paymentProcessor() -> paymentError   -> PMTPENDING
 * PMTPENDING -  pay    -> paymentProcessor() -> paymentSuccess -> COMPLETED 
 */
public enum OrderState implements ProcessState {

	Default,
	
	PaymentPending,
	
	Completed;
}
