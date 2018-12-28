package spring.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import spring.FortuneService;

//@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@DependsOn("parandomFortuneService")
public class HappyFortuneService implements FortuneService, InitializingBean {

    public HappyFortuneService() {
        System.out.println("HappyFS def ctor");
    }
    
    @Override
    public String getFortune() {
        return "Today is your lucky day";
    }

    @PostConstruct
    private void init() {
        System.out.println("happy init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("happy init with iface");
    }
}
