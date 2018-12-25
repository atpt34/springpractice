package epm.springtask;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.atpt34.config.AnotherAppConfig;
import com.gmail.atpt34.config.AppConfig;
import com.gmail.atpt34.config.XmlConfig;

public class AppRun {
    public static void main(String[] args) {
//        ConfigurableApplicationContext appCtx =
//                new ClassPathXmlApplicationContext("springContext.xml");
//    	ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class, XmlConfig.class, AnotherAppConfig.class);
    	ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        
//        SomeService service = appCtx.getBean(SomeService.class);
//        service.call();
        
        SomeComponent someComponent = appCtx.getBean("huawei", SomeComponent.class);
//        SomeComponent someComponent = (SomeComponent) appCtx.getBean("someComponent");
//        SomeComponent someComponent = appCtx.getBean(SomeComponent.class);
        System.out.println(someComponent);
        System.out.println(someComponent.getClass());
//        System.out.println(someComponent.getNames());
//        System.out.println(someComponent.getStr());
        System.out.println("calling update...");
//        someComponent.update("Wow");
        someComponent.update("a", "b");
//        someComponent.update("1", "2", "3");
        System.out.println("should not be printed, because of stackTrace");
        
        
//        appCtx.getBean("a");
//        appCtx.getBean("b");
//        appCtx.getBean("a");
//        appCtx.getBean("b");
        
//        System.out.println(appCtx.getBeansOfType(B.class).size());
        
    	
//        String[] beanDefinitionNames = appCtx.getBeanDefinitionNames();
//		System.out.println(beanDefinitionNames);
//        Stream.of(beanDefinitionNames).forEach(System.out::println);
       
//        appCtx.close();
        
        
    }
}
