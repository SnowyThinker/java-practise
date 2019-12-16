package org.snowythinker.statemachine.manager;

import org.snowythinker.statemachine.event.ProcessData;
import org.snowythinker.statemachine.event.order.OrderData;
import org.snowythinker.statemachine.exception.ProcessException;
import org.snowythinker.statemachine.service.OrderService;
import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderStateTransitionsManager extends AbstractStateTransitionsManager {

	private final ApplicationContext applicationContext;
	private final OrderService orderService;
	
	/*public OrderStateTransitionsManager(ApplicationContext applicationContext, OrderService orderService) {
		this.applicationContext = applicationContext;
		this.orderService = orderService;
	}*/
	
	@Override
	protected ProcessData initializeState(ProcessData data) throws ProcessException {
		OrderData orderData = (OrderData) data;
		this.applicationContext.getBean(data.getEvent().nextStepProcessor(data.getEvent())).process(data);
		
		return data;
	}

	@Override
	protected ProcessData processStateTransition(ProcessData data) throws ProcessException {
		// TODO Auto-generated method stub
		return null;
	}

}
