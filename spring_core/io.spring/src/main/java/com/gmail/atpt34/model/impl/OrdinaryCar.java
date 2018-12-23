package com.gmail.atpt34.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gmail.atpt34.layer.Engine;
import com.gmail.atpt34.model.Car;

@Component("car")
public class OrdinaryCar implements Car {

	@Value("${ordinaryCar.name}")
	private String name;
	
	private int year;
	
	@Autowired
	private Engine engine;
	
	public OrdinaryCar() {
		System.out.println("OrdinaryCar()");
	}

	@Override
	public void drive() {
		System.out.println("drive ordinary car");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Engine getEngine() {
		return engine;
	}
	
}
