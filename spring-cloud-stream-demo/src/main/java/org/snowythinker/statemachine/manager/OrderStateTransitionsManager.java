package org.snowythinker.statemachine.manager;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.snowythinker.statemachine.event.ProcessData;
import org.snowythinker.statemachine.event.order.OrderData;
import org.snowythinker.statemachine.event.order.OrderEvent;
import org.snowythinker.statemachine.event.order.OrderState;
import org.snowythinker.statemachine.exception.OrderException;
import org.snowythinker.statemachine.exception.ProcessException;
import org.snowythinker.statemachine.service.OrderService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class OrderStateTransitionsManager extends AbstractStateTransitionsManager {

	private final ApplicationContext applicationContext;
	private final OrderService orderService;
	
	/*public OrderStateTransitionsManager(ApplicationContext applicationContext, OrderService orderService) {
		this.applicationContext = applicationContext;
		this.orderService = orderService;
	}*/
	
	@Override
	protected ProcessData initializeState(ProcessData sdata) throws ProcessException {
		OrderData data = (OrderData) sdata;
        if (data.getOrderId() != null) {
            return checkStateForReturningCustomers(data);
        }
        UUID orderId = UUID.randomUUID();
        data.setOrderId(orderId);
        orderService.getStates().put(orderId, (OrderState) OrderState.Default);
        log.info("Initial state: " + orderService.getStates().get(data.getOrderId()).name());
        return data;
	}
	
	private OrderData checkStateForReturningCustomers(OrderData data) throws OrderException {
        // returning customers must have a state
        if (data.getOrderId() != null) {
            if (this.orderService.getStates().get(data.getOrderId()) == null) {
                throw new OrderException("No state exists for orderId=" + data.getOrderId());
            } else if (this.orderService.getStates().get(data.getOrderId()) == OrderState.Completed) {
                throw new OrderException("Order is completed for orderId=" + data.getOrderId());
            } else {
                log.info("Initial state: " + orderService.getStates().get(data.getOrderId()).name());
            }
        }
        return data;
    }

	@Override
	protected ProcessData processStateTransition(ProcessData data) throws ProcessException {
		OrderData orderData = (OrderData) data;
		try {
			log.info("Pre-event: " + data.getEvent().toString());
			 
			this.applicationContext.getBean(data.getEvent().nextStepProcessor(data.getEvent())).process(data);
			
			log.info("Post-event: " + data.getEvent().toString());
			
			orderService.getStates().put(orderData.getOrderId(), (OrderState)data.getEvent().nextState(data.getEvent()));
			log.info("Final state: " + orderService.getStates().get(orderData.getOrderId()).name());
		} catch (BeansException e) {
			log.info("Post-event: " + ((OrderEvent) data.getEvent()).name());
			orderService.getStates().put(orderData.getOrderId(), (OrderState)data.getEvent().nextState(data.getEvent()));
            log.info("Final state: " + orderService.getStates().get(orderData.getOrderId()).name());
            log.info("??*************************************");
            throw new OrderException(((OrderEvent) data.getEvent()).name(), e);
		}
		
		return data;
	}

	public ConcurrentHashMap<UUID, OrderState> getStates() {
        return orderService.getStates();
    }
}
