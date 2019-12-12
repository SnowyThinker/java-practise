package org.snowythinker.statemachine.event.order;

import org.snowythinker.statemachine.event.ProcessState;

public enum OrderState implements ProcessState {

	Default,
	
	PaymentPending,
	
	Completed;
}
