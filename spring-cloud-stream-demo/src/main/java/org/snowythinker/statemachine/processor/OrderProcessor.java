package org.snowythinker.statemachine.processor;

import org.snowythinker.statemachine.event.ProcessData;
import org.snowythinker.statemachine.event.Processor;
import org.snowythinker.statemachine.event.order.OrderData;
import org.snowythinker.statemachine.event.order.OrderEvent;
import org.snowythinker.statemachine.exception.ProcessException;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessor implements Processor {

	@Override
	public ProcessData process(ProcessData data) throws ProcessException {
		((OrderData)data).setEvent(OrderEvent.orderCreated);
		return data;
	}
}
