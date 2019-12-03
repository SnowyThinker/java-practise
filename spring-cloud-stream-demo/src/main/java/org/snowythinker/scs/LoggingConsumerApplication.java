package org.snowythinker.scs;

import org.snowythinker.scs.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LoggingConsumerApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(LoggingConsumerApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@StreamListener(Sink.INPUT)
	public void handle(Person person) {
		log.info("Received: {}", person);
	}
}
