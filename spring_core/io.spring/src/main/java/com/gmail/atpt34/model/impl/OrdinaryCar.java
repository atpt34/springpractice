package com.gmail.atpt34.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gmail.atpt34.layer.Engine;
import com.gmail.atpt34.layer.impl.Wheel;
import com.gmail.atpt34.model.Car;

@Component("car")
public class OrdinaryCar implements Car {

	@Value("${ordinaryCar.name}")
	private String name;
	
	@Value("#{ 2 + 2}")
	private int year;
	
	@Autowired
	private Engine engine;
	
	public OrdinaryCar() {
		System.out.println("OrdinaryCar() of year " + year);
	}

	@Override
	public void drive() {
		System.out.println("drive ordinary car");
	}

	@Override
	public String getName() {
		return name + " of year " + year;
	}

	@Override
	public Engine getEngine() {
		return engine;
	}

	@Override
	public List<Wheel> getWheels() {
		return null;
	}
	
}
