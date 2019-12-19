package org.snowythinker.statemachine.config;

import java.util.EnumSet;

import javax.annotation.PostConstruct;

import org.snowythinker.statemachine.ShipmentStatus;
import org.snowythinker.statemachine.ShipmentStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachine
public class OrderStatusConfig extends EnumStateMachineConfigurerAdapter<ShipmentStatus, ShipmentStatusEvent> {

	@Autowired
	StateMachine<ShipmentStatus, ShipmentStatusEvent> stateMachine;
	
	@PostConstruct
	public void postpone() {
		stateMachine.start();
	}

	@Override
	public void configure(StateMachineStateConfigurer<ShipmentStatus, ShipmentStatusEvent> states) throws Exception {
		states.withStates()
		.initial(ShipmentStatus.CREATED)
		.states(EnumSet.allOf(ShipmentStatus.class));
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<ShipmentStatus, ShipmentStatusEvent> transitions)
			throws Exception {
		
		transitions.withExternal()
		.source(ShipmentStatus.CREATED).target(ShipmentStatus.PAID).event(ShipmentStatusEvent.PAID)
		.and().withExternal()
		.source(ShipmentStatus.CREATED).target(ShipmentStatus.CANCELLED).event(ShipmentStatusEvent.CANCELLED);
	}
	
	
}
