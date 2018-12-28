package spring.impl;

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
