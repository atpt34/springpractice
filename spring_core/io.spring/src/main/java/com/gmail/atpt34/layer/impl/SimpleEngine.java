package com.gmail.atpt34.layer.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.gmail.atpt34.layer.Engine;

@Component
@Primary
public class SimpleEngine implements Engine {

	public SimpleEngine() {
		System.out.println("SimpleEngine()");
	}
	
	@Override
	public void startEngine() {
		System.out.println("Starting simple engine...");
	}

}
