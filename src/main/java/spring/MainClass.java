package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.impl.C;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("========== Main method ============");
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("=========== Spring context created ============");
        String property = context.getEnvironment().getProperty("foo.name");
        System.out.println("property foo.name is " + property);
        
//        TennisCoach theTennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        Coach theTennisCoach = context.getBean("tennisCoach", Coach.class);
//        TennisCoach theTennisCoach = context.getBean(TennisCoach.class);
        System.out.println(theTennisCoach);
        System.out.println(theTennisCoach.getFortuneService());
        System.out.println(theTennisCoach.getDailyWorkout());
        System.out.println(theTennisCoach.getDailyFortune());
        
        System.out.println(theTennisCoach.getClass());
        System.out.println(Integer.toHexString(theTennisCoach.hashCode()));
        System.out.println(Integer.toHexString(System.identityHashCode(theTennisCoach)));
        
//        theTennisCoach.setAge("33"); // do not affect default hashCode impl
//        theTennisCoach.setFlag(true);
//        System.out.println(Integer.toHexString(theTennisCoach.hashCode()));
//        System.out.println(Integer.toHexString(System.identityHashCode(theTennisCoach)));
//        System.out.println(theTennisCoach);
        
//        Coach theTennisCoach2 = context.getBean("tennisCoach", Coach.class);
//        System.out.println(theTennisCoach2);
//        System.out.println(theTennisCoach2.getFortuneService());
//        System.out.println(theTennisCoach2.getDailyWorkout());
//        System.out.println(theTennisCoach2.getDailyFortune());
//        
//        System.out.println(theTennisCoach == theTennisCoach2);
//        
        Coach theCoach = context.getBean("trener", Coach.class);
        System.out.println(theCoach);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        
        Coach theCoach2 = context.getBean("coach", Coach.class);
        System.out.println(theCoach2);
        System.out.println(theCoach2.getDailyWorkout());
        System.out.println(theCoach2.getDailyFortune());
        
        FortuneService fortuneService = context.getBean(FortuneService.class);
        System.out.println(fortuneService);
        System.out.println(fortuneService.getClass());
        
        System.out.println(context.getBean("dodo").getClass());
        
//        System.out.println(context.getBean("main"));
//        System.out.println(context.getBean("main"));
        
        C c = context.getBean(C.class);
        System.out.println(c.getB().getA());
        System.out.println(c.getB());
        System.out.println(c);
        System.out.println(c.getD());
        
        System.out.println("================ Call context close =====================");
        context.close();
    }

}
