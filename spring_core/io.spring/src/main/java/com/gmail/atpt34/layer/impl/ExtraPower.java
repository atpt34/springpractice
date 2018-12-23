package com.gmail.atpt34.layer.impl;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("hyperEngine")
public class ExtraPower {
	
	public ExtraPower() {
		System.out.println("ExtraPower() can only be used with hyperEngine");
	}
	
	//postconstuct & predestroy
}
