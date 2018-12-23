package com.gmail.atpt34.layer.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gmail.atpt34.layer.Engine;

@Component
@Scope("prototype")
public class HyperEngine implements Engine, InitializingBean {

	public HyperEngine() {
		System.out.println("HyperEngine()");
	}
	
	@Override
	public void startEngine() {
		System.out.println("super-duper powerful engine is ready!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("hyperEngine props set");
	}

}
