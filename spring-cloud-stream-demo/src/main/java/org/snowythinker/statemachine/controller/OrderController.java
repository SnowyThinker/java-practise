package org.snowythinker.statemachine.controller;

import java.util.UUID;

import org.snowythinker.statemachine.event.order.OrderData;
import org.snowythinker.statemachine.event.order.OrderEvent;
import org.snowythinker.statemachine.manager.OrderStateTransitionsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OrderController {

	private final OrderStateTransitionsManager stateTransitionsManager;
	
	@GetMapping("/order/cart")
	public String handleOrderPayment(@RequestParam double payment, @RequestParam UUID orderId) throws Exception {
		OrderData orderData = new OrderData();
		orderData.setPayment(payment);
		orderData.setOrderId(orderId);
		orderData.setEvent(OrderEvent.pay);
		
		orderData = (OrderData) this.stateTransitionsManager.processEvent(orderData);
		
		return ((OrderEvent)orderData.getEvent()).name();
	}
	
	@GetMapping("/order")
	public String handleOrderSumit() throws Exception {
		OrderData data = new OrderData();
		data.setEvent(OrderEvent.submit);
		data = (OrderData) this.stateTransitionsManager.processEvent(data);
		
		return ((OrderEvent)data.getEvent()).name() + ", orderId=" + data.getOrderId();
	}
}
