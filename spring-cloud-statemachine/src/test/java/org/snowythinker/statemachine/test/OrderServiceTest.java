package org.snowythinker.statemachine.test;

import org.junit.jupiter.api.Test;
import org.snowythinker.statemachine.ShipmentStatus;
import org.snowythinker.statemachine.ShipmentStatusEvent;
import org.snowythinker.statemachine.service.ShipmentService;
import org.snowythinker.test.AppTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;

public class OrderServiceTest extends AppTest {

	@Autowired
	private ShipmentService orderService;
	
	@Autowired
	StateMachine<ShipmentStatus, ShipmentStatusEvent> stateMachine;
	
	@Test
	public void testCreateOrder() throws InterruptedException {
		stateMachine.sendEvent(ShipmentStatusEvent.PAID);
		
		Thread.sleep(10000);
	}
}
