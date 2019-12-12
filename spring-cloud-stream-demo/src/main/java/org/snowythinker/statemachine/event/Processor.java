package org.snowythinker.statemachine.event;

import org.snowythinker.statemachine.exception.ProcessException;

public interface Processor {

	public ProcessData process(ProcessData data) throws ProcessException;
}
