package com.gmail.atpt34.model;

import java.util.List;

import com.gmail.atpt34.layer.Engine;
import com.gmail.atpt34.layer.impl.Wheel;

public interface Car {
	
	void drive();
	
	String getName();
	
	Engine getEngine();

	List<Wheel> getWheels();

	void setEngine(Engine engine);

	void setName(String name);
}
