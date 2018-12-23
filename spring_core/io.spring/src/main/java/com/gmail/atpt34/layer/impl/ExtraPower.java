package com.gmail.atpt34.layer.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("hyperEngine")
public class ExtraPower implements InitializingBean {
	
	public ExtraPower() {
		System.out.println("ExtraPower() can only be used with hyperEngine");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("extraPower props set");
	}
}
