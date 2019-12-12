package org.snowythinker.statemachine.Listener;

import org.snowythinker.statemachine.OrderStatus;
import org.snowythinker.statemachine.OrderStatusEvent;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusEventListener extends StateMachineListenerAdapter<OrderStatus, OrderStatusEvent> {

	@Override
	public void stateChanged(State<OrderStatus, OrderStatusEvent> from, State<OrderStatus, OrderStatusEvent> to) {
		super.stateChanged(from, to);
	}

}
