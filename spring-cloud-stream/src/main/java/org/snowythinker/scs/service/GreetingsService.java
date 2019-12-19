package org.snowythinker.scs.service;

import org.snowythinker.scs.config.GreetingsStreams;
import org.snowythinker.scs.model.Greetings;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GreetingsService {

	private final GreetingsStreams greetingsStreams;
	
	
	public boolean sendGreeting(final Greetings greetings) {
		
		MessageChannel messageChannel = greetingsStreams.outboundGreetings();
		
		Message<Greetings> messageBody = MessageBuilder
			.withPayload(greetings)
			.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
			.build();
		
		return messageChannel.send(messageBody);
	}
}
