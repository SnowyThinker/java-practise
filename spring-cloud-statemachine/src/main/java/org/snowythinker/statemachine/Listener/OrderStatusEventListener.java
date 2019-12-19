package org.snowythinker.statemachine.Listener;

import org.snowythinker.statemachine.ShipmentStatus;
import org.snowythinker.statemachine.ShipmentStatusEvent;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusEventListener extends StateMachineListenerAdapter<ShipmentStatus, ShipmentStatusEvent> {

	@Override
	public void stateChanged(State<ShipmentStatus, ShipmentStatusEvent> from, State<ShipmentStatus, ShipmentStatusEvent> to) {
		super.stateChanged(from, to);
	}

}
