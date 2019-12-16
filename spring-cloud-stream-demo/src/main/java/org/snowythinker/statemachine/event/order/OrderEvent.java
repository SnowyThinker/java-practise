package org.snowythinker.statemachine.event.order;

import org.snowythinker.statemachine.event.ProcessEvent;
import org.snowythinker.statemachine.event.ProcessState;
import org.snowythinker.statemachine.event.Processor;
import org.snowythinker.statemachine.processor.OrderProcessor;
import org.snowythinker.statemachine.processor.PaymentProcessor;

/**  
 * DEFAULT    -  submit -> orderProcessor()   -> orderCreated   -> PMTPENDING
 * PMTPENDING -  pay    -> paymentProcessor() -> paymentError   -> PMTPENDING
 * PMTPENDING -  pay    -> paymentProcessor() -> paymentSuccess -> COMPLETED 
 */
public enum OrderEvent implements ProcessEvent {
	
	submit{
		@Override
		public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
			return OrderProcessor.class;
		}

		@Override
		public ProcessState nextState(ProcessEvent event) {
			return OrderState.Default;
		}
	},
	orderCreated {
		@Override
		public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
			return null;
		}

		@Override
		public ProcessState nextState(ProcessEvent event) {
			return OrderState.PaymentPending;
		}
	}, 
	
	pay {
		@Override
		public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
			return PaymentProcessor.class;
		}

		@Override
		public ProcessState nextState(ProcessEvent event) {
			return OrderState.PaymentPending;
		}
	},
	paymentSuccess {
		@Override
		public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
			return null;
		}

		@Override
		public ProcessState nextState(ProcessEvent event) {
			return OrderState.Completed;
		}
	},
	paymentError {
		@Override
		public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
			return null;
		}

		@Override
		public ProcessState nextState(ProcessEvent event) {
			return OrderState.PaymentPending;
		}
	}
	;
}
