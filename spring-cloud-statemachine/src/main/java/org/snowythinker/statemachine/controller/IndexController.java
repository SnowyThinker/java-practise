package org.snowythinker.statemachine.controller;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IndexController {
	
	@PostConstruct
	public void init() {
		log.info("init");
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
