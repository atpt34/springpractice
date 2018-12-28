package spring.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.*;

import spring.FortuneService;

//@Component
//@Lazy
public class ExperimentalComponent 
    implements 
        InitializingBean, DisposableBean, 
        BeanPostProcessor, BeanFactoryPostProcessor, 
        BeanNameAware, ApplicationContextAware {

    public ExperimentalComponent() {
        System.out.println("experiment created ");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("experiment destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("experiment init");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
//        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        Stream.<String>of(beanDefinitionNames).forEach(System.out::println);
//        FortuneService coach = beanFactory.getBean(HappyFortuneService.class);
//        System.out.println(coach);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization " + beanName);
        return bean;
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + beanName + " " + bean);
        if (bean instanceof TennisCoach) {
            TennisCoach coach = (TennisCoach) bean;
            System.out.println(coach.getAge() + " " + coach.getName());
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }
}
