package spring.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

import spring.Coach;
import spring.FortuneService;

//@Component()
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach { //, InitializingBean, DisposableBean {

//    @Value("Oleksii")
//    @Value("${foo.name}") // from property file
//    @Value("#{ context.getEnvironment().getProperty(\"foo.name\") + \"Trt\"}")
    private String name;
    
//    @Value("#{23 + 10}") //SpEL
    private String age;
    
    @Value("${flag.value:true}")
    private boolean flag;
    
//    @Autowired
//    @Qualifier(value="databaseFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("TennisCoach default ctor");
    }
    
    public TennisCoach(String name, String age) {
        this.name = name;
        this.age = age;
    }
    
    public static TennisCoach of() {
        System.out.println("TennisCoach factory static method");
        return new TennisCoach();
    }
    
//    @Autowired
//    public TennisCoach(@Qualifier("parandomFortuneService") FortuneService fortuneService) {
//        System.out.println("TennisCoach arg ctor");
//        this.fortuneService = fortuneService;
//    }
    
    @Override
    public String getDailyWorkout() {
        flag = false;
        age = "abc";
        return "getDailyWorkout() Practice your backhand valley with " + name + " of age " + age;
    }

    @Override
    public String getDailyFortune() {
        return getFortuneService().getFortune();
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

//    @Autowired()
//    @Qualifier("dodo")
    @Override
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("fortuneservice setter");
        this.fortuneService = fortuneService;
    }
    
//    @Autowired
//    @Qualifier("happyFortuneService")
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println("fortuneservice doCrazy method");
//        this.fortuneService = fortuneService;
//    }

    @PostConstruct
    private void doInit() {
        System.out.println("tennisCoach init with PostConstruct annot.");
        System.out.println("name = " + name + ", age = " + age + ", flag = " + flag);
    }
    
    @PreDestroy
    public void doDestroy() {
        System.out.println("destroy with annot.");
    }
    
//    @EventListener
//    public void doListen(ContextRefreshedEvent event) {
//        System.out.println("listen");
//    }

//    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("tennisCoach init with afterPropsSet method");
    }

//    @Override
    public void destroy() throws Exception {
        System.out.println("destroy with method of iface");
    }
    
    public boolean isFlag() {
        return flag;
    }
    
    public String getAge() {
        return age;
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
}
