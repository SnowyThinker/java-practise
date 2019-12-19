package org.snowythinker.statemachine.service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.snowythinker.statemachine.event.order.OrderState;
import org.springframework.stereotype.Repository;

@Repository
public class OrderService {
	
	private final ConcurrentHashMap<UUID, OrderState> states;
	
	public OrderService() {
		states = new ConcurrentHashMap<UUID, OrderState>();
	}
	
	public ConcurrentHashMap<UUID, OrderState> getStates() {
		return states;
	}

}
