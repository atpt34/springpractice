package spring.impl;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import spring.FortuneService;

//@Component
//@Primary
//@DependsOn("happyFortuneService")
public class DatabaseFortuneService implements FortuneService {

    public DatabaseFortuneService() {
        System.out.println("DatabaseFS def ctor");
    }
    
    @Override
    public String getFortune() {
        return "Database rush";
    }

    @PostConstruct
    private void init() {
        System.out.println("database init");
    }
}
