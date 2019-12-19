package org.snowythinker.scs.service;

import org.snowythinker.scs.model.Greetings;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GreetingsController {

	private final GreetingsService greetingsService;
	
	@GetMapping("/greetings")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void greetings(@RequestParam("message") String message) {
		Greetings greetings = Greetings.builder()
				.message(message)
				.timestamp(System.currentTimeMillis()).build();
		
		greetingsService.sendGreeting(greetings);
	}
}
