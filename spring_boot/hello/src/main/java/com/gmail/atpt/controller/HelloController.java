package com.gmail.atpt.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gmail.atpt.model.Message;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

	private final AtomicInteger counter = new AtomicInteger();
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Oleksii Spring's boot!";
	}
	
	@RequestMapping("/demo")
	public String demo() {
		return "Demo url";
	}
	
	@RequestMapping("/demo/specific")
	public String specific() {
		return "More specific demo url";
	}

	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/message")
	public Message message(@RequestParam(value="name", defaultValue="World") String name) {
		
		logger.info(counter.get() + " " + name);
		
        return new Message(counter.incrementAndGet(), "Doom", "hello " + name);                
	}
}
