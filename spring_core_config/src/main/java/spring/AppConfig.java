package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import spring.impl.A;
import spring.impl.B;
import spring.impl.C;
import spring.impl.D;
import spring.impl.DatabaseFortuneService;
import spring.impl.ExperimentalComponent;
import spring.impl.HappyFortuneService;
import spring.impl.RandomFortuneService;
import spring.impl.SimpleAspect;
import spring.impl.TennisCoach;

/**
 * 
 * ! Do not forget to set compiler compliance level to java 8. 
 *
 * I can gather all specific bean declarations here in one place!!!
 *
 */
@Configuration
//@ComponentScan(basePackages="spring")
@PropertySource("classpath:my.propertyies")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MainClass main() {
        return new MainClass();
    }
    
    @Bean
//    @DependsOn("tennisCoach")  // this is circular dependency !!!
    public RandomFortuneService parandomFortuneService() {
        return new RandomFortuneService();
    }
    
    @Bean
    @DependsOn("parandomFortuneService")
    public HappyFortuneService happyFortuneService() {
        return new HappyFortuneService();
    }

    @Bean
    @Primary
    @DependsOn("happyFortuneService")
    public FortuneService databaseFortuneService() {
        return new DatabaseFortuneService();
    }

    @Bean(name = {"coach", "trener"})
    @Lazy
    public Coach createMirrorCoach(@Autowired @Qualifier("tennisCoach") Coach coach) {
        System.out.println("inside createMirror method" + coach);
        return coach;
    }
    
    @Bean
    FortuneService dodo() {
        System.out.println("create bean randomFortuneService ONE");
        return new HappyFortuneService();
    }
    
    @Bean
    FortuneService dodo2(Coach tennisCoach) { // Injects using local variable name!
        System.out.println("create bean randomFortuneService TWO");
        return new RandomFortuneService();
    }
    
    @Bean
    @Primary
    Coach tennisCoach(@Autowired FortuneService fortuneService, @Value("${foo.name}") String name, @Value("#{-1 + 34}") String age) {
        TennisCoach tennisCoach = new TennisCoach(name, age);
        tennisCoach.setFortuneService(fortuneService);
        return tennisCoach;
    }
    
//    @Bean  // no need in bean that sets other beans!!!
    public Coach doSet(@Autowired Coach coacher, @Autowired FortuneService fortuneService) {
        System.out.println("doSet"); // not executed
        coacher.setFortuneService(fortuneService);
        return coacher;
    }
    
    @Bean
    @Lazy
    SimpleAspect simpleAspect() {
        return new SimpleAspect();
    }
    
    @Bean
    public static ExperimentalComponent experimentalComponent() {
        return new ExperimentalComponent();
    }
    
    // YOU SHOULD PROVIDE ALL DEPENDENCIES
    
    @Bean
    public D dd(@Autowired B b) {
        return new D(b);
    }
    
    @Bean
//    @DependsOn({"bb", "dd"}) // unnecessary
    public C cc(@Autowired @Qualifier("bb") B b, D d) {
        return new C(b, d);
    }
    
    @Bean
//    @DependsOn("aaa")
    public B bb(A a) {
        return new B(a);
    }
    
    @Bean
    public A aaa() {
        return new A();
    }
    
    
    // another approach:
    
    @Autowired
    ApplicationContext context;
    
    @Bean
    public Coach newTennisCoach() {
    	TennisCoach tennisCoach = new TennisCoach();
    	FortuneService fortuneService = context.getBean("parandomFortuneService", FortuneService.class);
		tennisCoach.setFortuneService(fortuneService);
		return tennisCoach;
    }
    
    // but this is better...
    
    @Bean
    public Coach newTennisCoach2(@Autowired @Qualifier("parandomFortuneService") FortuneService fortuneService) {
    	TennisCoach tennisCoach = new TennisCoach();
		tennisCoach.setFortuneService(fortuneService);
		return tennisCoach;
    }
}
