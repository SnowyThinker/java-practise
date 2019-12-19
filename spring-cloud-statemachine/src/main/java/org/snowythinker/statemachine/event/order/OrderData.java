package org.snowythinker.statemachine.event.order;

import java.util.UUID;

import org.snowythinker.statemachine.event.ProcessData;
import org.snowythinker.statemachine.event.ProcessEvent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderData implements ProcessData {
	
	private double payment;
	private ProcessEvent event;
	private UUID orderId;

	@Override
	public ProcessEvent getEvent() {
		return event;
	}
}
