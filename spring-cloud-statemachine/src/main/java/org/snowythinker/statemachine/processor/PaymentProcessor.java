package org.snowythinker.statemachine.processor;

import org.snowythinker.statemachine.event.ProcessData;
import org.snowythinker.statemachine.event.Processor;
import org.snowythinker.statemachine.event.order.OrderData;
import org.snowythinker.statemachine.event.order.OrderEvent;
import org.snowythinker.statemachine.exception.PaymentException;
import org.snowythinker.statemachine.exception.ProcessException;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessor implements Processor {

	@Override
	public ProcessData process(ProcessData data) throws ProcessException {
		OrderData orderData = (OrderData) data;
		if(orderData.getPayment() < 1.00) {
			orderData.setEvent(OrderEvent.paymentError);
			throw new PaymentException(OrderEvent.paymentError.name());
		} else {
			orderData.setEvent(OrderEvent.paymentSuccess);
		}
		return data;
	}
}
