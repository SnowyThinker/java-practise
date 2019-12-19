package org.snowythinker.scs.listener;

import org.snowythinker.scs.config.GreetingsStreams;
import org.snowythinker.scs.model.Greetings;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GreetingsListener {

	@StreamListener(GreetingsStreams.INPUT)
	public void handleGreetings(@Payload Greetings greetings) {
		log.info("handleGreetings: {}", greetings);
	}
}
