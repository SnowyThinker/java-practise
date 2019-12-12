package org.snowythinker.statemachine.event.order;

import org.snowythinker.statemachine.event.ProcessEvent;
import org.snowythinker.statemachine.event.ProcessState;
import org.springframework.cloud.stream.messaging.Processor;

public enum OrderEvent implements ProcessEvent {
	
	submit{
		@Override
		public Class<? extends Processor> nextStepProcessor(ProcessEvent event) {
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			return OrderProcessor.class;
		}

		@Override
		public ProcessState nextState(ProcessEvent event) {
			return OrderState.Default;
		}
	}, 
	
	paymentError, 
	
	paymentSuccess
	;

	


}
