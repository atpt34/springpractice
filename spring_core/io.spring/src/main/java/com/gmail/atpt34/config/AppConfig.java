package com.gmail.atpt34.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.gmail.atpt34.model.Car;
import com.gmail.atpt34.model.impl.FutureCar;
import com.gmail.atpt34.model.impl.OrdinaryCar;

@Configuration
//@ComponentScan("com.gmail.atpt34")
@PropertySource("classpath:app.properties")
public class AppConfig {

	@Bean
	@Primary
	public Car getOnWheels() {
		return new OrdinaryCar();
	}
	
	@Bean
	@Lazy
	public Car getBossVehicle() {
		return new FutureCar();
	}
}
