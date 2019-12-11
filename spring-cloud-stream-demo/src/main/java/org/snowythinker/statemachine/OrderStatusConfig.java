package org.snowythinker.statemachine;

import java.util.EnumSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachine
public class OrderStatusConfig extends EnumStateMachineConfigurerAdapter<OrderStatus, OrderStatusEvent> {

	@Autowired
	StateMachine<OrderStatus, OrderStatusEvent> stateMachine;
	
	@PostConstruct
	public void postpone() {
		stateMachine.start();
	}

	@Override
	public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusEvent> states) throws Exception {
		states.withStates()
		.initial(OrderStatus.CREATED)
		.states(EnumSet.allOf(OrderStatus.class));
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusEvent> transitions)
			throws Exception {
		
		transitions.withExternal()
		.source(OrderStatus.CREATED).target(OrderStatus.PAID).event(OrderStatusEvent.PAID)
		.source(OrderStatus.CREATED).target(OrderStatus.CANCELLED).event(OrderStatusEvent.CANCELLED);
	}
	
	
}
