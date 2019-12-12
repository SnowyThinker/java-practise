package org.snowythinker.statemachine.test;

import org.junit.jupiter.api.Test;
import org.snowythinker.statemachine.OrderStatus;
import org.snowythinker.statemachine.OrderStatusEvent;
import org.snowythinker.statemachine.service.OrderService;
import org.snowythinker.test.AppTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;

public class OrderServiceTest extends AppTest {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	StateMachine<OrderStatus, OrderStatusEvent> stateMachine;
	
	@Test
	public void testCreateOrder() throws InterruptedException {
		stateMachine.sendEvent(OrderStatusEvent.PAID);
		
		Thread.sleep(10000);
	}
}
