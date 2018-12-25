package com.gmail.atpt34.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gmail.atpt34.layer.Engine;
import com.gmail.atpt34.layer.impl.HyperEngine;
import com.gmail.atpt34.layer.impl.SimpleEngine;

@Configuration
public class AnotherAppConfig {

	@Bean
	public Engine blahBlah() {
//		return new SimpleEngine();
		return new HyperEngine();
	}
}
