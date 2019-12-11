package org.snowythinker.statemachine.service;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@WithStateMachine
@Component
@Slf4j
public class OrderService {

	@OnTransition(target="CREATED")
	public void createOrder() {
		log.info("create order");
	}
	
	@OnTransition(target="PAID")
	public void payment() {
		log.info("payment");
	}
}
