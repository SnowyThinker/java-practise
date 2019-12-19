package org.snowythinker.statemachine.manager;

import org.snowythinker.statemachine.event.ProcessData;
import org.snowythinker.statemachine.exception.ProcessException;

public abstract class AbstractStateTransitionsManager implements StateTransactionManager {

	protected abstract ProcessData initializeState(ProcessData data) throws ProcessException;
	
	protected abstract ProcessData processStateTransition(ProcessData data) throws ProcessException;
	
	@Override
	public ProcessData processEvent(ProcessData data) throws ProcessException {
		initializeState(data);
		return processStateTransition(data);
	}
}
