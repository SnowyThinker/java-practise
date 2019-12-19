package org.snowythinker.statemachine.manager;

import org.snowythinker.statemachine.event.ProcessData;
import org.snowythinker.statemachine.exception.ProcessException;

public interface StateTransactionManager {

	public ProcessData processEvent(ProcessData data) throws ProcessException;
}
