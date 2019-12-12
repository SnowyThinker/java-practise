package org.snowythinker.statemachine.service;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@WithStateMachine
@Component
@Slf4j
public class ShipmentService {

	@OnTransition(target="CREATED")
	public void createShipment() {
		log.info("create Shipment");
	}
	
	@OnTransition(target="PAID")
	public void payment() {
		log.info("payment");
	}
}
