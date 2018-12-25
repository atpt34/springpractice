package com.gmail.atpt34.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EasyAspect {

//	@Pointcut("execution(* update(..))")
//	public void pointcut( ) {
//		
//	}
//	
//	@After("execution(public String *(..))")
//	public void justAfter() {
//		System.out.println("justAfter");
//	}
//	
//	@AfterReturning("execution(* *..SomeComponent.update(..))")
//	public void afterReturning() {
//		System.out.println("afterReturning");
//	}
	
//	@AfterThrowing("execution(* *..SomeComponent.*(..))")
//	public void afterThrowing() {
//		System.out.println("afterThrowing");
//	}
	
//	@Around("execution(public * *..SomeComponent.*(..))")
//	public void around() {
//		System.out.println("around");
//	}
	
	@Around("execution(* epm.springtask.*SomeComponent.*(*,*))")
	public void around() {
		System.out.println("around");
	}
}
