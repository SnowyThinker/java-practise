package org.snowythinker.scs.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface GreetingsStreams {

	String INPUT = "greeting-input";
	String OUTPUT = "greeting-output";
	
	@Input(INPUT)
	SubscribableChannel inboundGreetings();
	
	@Output(OUTPUT)
	MessageChannel outboundGreetings();
}
