package org.snowythinker.statemachine.event;

import org.springframework.cloud.stream.messaging.Processor;

public interface ProcessEvent {

	public abstract Class<? extends Processor> nextStepProcessor(ProcessEvent event);
	
	public abstract ProcessState nextState(ProcessEvent event);
}
