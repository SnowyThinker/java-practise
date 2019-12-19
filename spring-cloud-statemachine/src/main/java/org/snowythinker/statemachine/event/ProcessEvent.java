package org.snowythinker.statemachine.event;


public interface ProcessEvent {

	public abstract Class<? extends Processor> nextStepProcessor(ProcessEvent event);
	
	public abstract ProcessState nextState(ProcessEvent event);
}
