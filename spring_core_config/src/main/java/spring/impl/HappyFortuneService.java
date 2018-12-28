package spring.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

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
