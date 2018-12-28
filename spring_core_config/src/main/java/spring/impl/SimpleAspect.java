package spring.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventListenerMethodProcessor;

import spring.Coach;

@Aspect
//@Component
//@Lazy
public class SimpleAspect implements InitializingBean, DisposableBean {
    
    public SimpleAspect() {
        System.out.println("SimpleAspect()");
    }
    
    
    @Pointcut("execution(public * getDailyWorkout(..))")
    private void anyPublicOperation() {
        System.out.println("aspect pointcut");
    }

    @Before("execution(public String spring.Coach.getDailyWorkout(..))")
    private void anyPublicOperation2() {
        System.out.println("aspect before");
    }
    
    @After("execution(public * getDailyWorkout(..))")
    private void anyPublicOperation3() {
        System.out.println("aspect after");
    }
    
    @AfterReturning(pointcut = "execution(public * getDailyWorkout(..))", returning="ret")
    private void anyPublicOperation4(Object ret) {
        System.out.println("aspect after returning");
        System.out.println(ret);
        System.out.println(ret.getClass());
    }
    
    @Around("execution(public * getDailyWorkout(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aspect around start");
        Coach target = (Coach) pjp.getTarget();
        System.out.println(target);
        System.out.println(target.getAge());
        // start stopwatch
        
        Object retVal = pjp.proceed();
        
        // stop stopwatch
        System.out.println("aspect around stop");
        System.out.println(target.getAge());
        
        return retVal;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("destroy aspect");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init aspect");
    }
    
    @EventListener
    public void listen(EventListenerMethodProcessor event) {
        System.out.println("event aspect");
        System.out.println(event);
    }
}
