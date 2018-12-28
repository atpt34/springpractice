package spring.impl;

import javax.annotation.PostConstruct;

import spring.FortuneService;

//@Component("parandomFortuneService")
//@Service
//@Primary
//@DependsOn("tennisCoach")
public class RandomFortuneService implements FortuneService {

//    @Autowired
//    @Qualifier("trener")
//    private Coach coach;
    
//    @Autowired
//    public RandomFortuneService(@Qualifier("trener") Coach coach) {
//        this.coach = coach;
//        System.out.println("RandomFS arg ctor");
//    }
    
//    @Autowired
//    @Qualifier("trener")
//    public void setCoach(Coach coach) {
//        System.out.println("coach setter in random");
//        this.coach = coach;
//    }
    
    public RandomFortuneService() {
        System.out.println("RandomFS def ctor");
    }
    
    @Override
    public String getFortune() {
        return "Random shit"; // + coach.toString();
    }
    
    @PostConstruct
    private void init() {
        System.out.println("random init");
    }

}
