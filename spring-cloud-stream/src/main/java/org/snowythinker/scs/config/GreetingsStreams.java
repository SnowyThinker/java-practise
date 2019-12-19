package org.snowythinker.scs.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface GreetingsStreams {

	//String INPUT = "greeting-input";
	String OUTPUT = "greeting-output";
	
	//@Input(INPUT)
	//SubscribableChannel inboundGreetings();
	
	@Output(OUTPUT)
	MessageChannel outboundGreetings();
}
