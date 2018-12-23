package com.gmail.atpt34.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gmail.atpt34.layer.Engine;
import com.gmail.atpt34.layer.impl.ExtraPower;
import com.gmail.atpt34.model.Car;

@Component
@Lazy
public class FutureCar implements Car {

	@Value("${futureCar.name}")
	private String name;
	
	private Engine engine;
	
	@Autowired
	private ExtraPower power;

	public FutureCar() {
		System.out.println("FutureCar()");
	}
	
	public FutureCar(@Autowired @Qualifier("extraPower") 
						ExtraPower power) {
		this.power = power;
	}
	
	@Override
	public void drive() {
		System.out.println("Driving " + name + " car with " + engine + " engine & power " + power);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Engine getEngine() {
		return engine;
	}

	@Autowired
	@Qualifier("hyperEngine")
	public void setEngine(Engine engine) {
		System.out.println("setting engine " + engine);
		this.engine = engine;
	}
}
