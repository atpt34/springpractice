package com.gmail.atpt34.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gmail.atpt34.config.AnotherAppConfig;
import com.gmail.atpt34.config.AppConfig;
import com.gmail.atpt34.layer.Engine;
import com.gmail.atpt34.model.Car;

public class MainRunner {

	public static void main(String[] args) {
		System.out.println("main(.)");
		
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(AppConfig.class, AnotherAppConfig.class);
		
		
//		AnnotationConfigApplicationContext context = 
//				new AnnotationConfigApplicationContext();
//		context.scan("com.gmail.atpt34");
//		context.register(AppConfig.class);
//		context.refresh();
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springxmlconfig.xml");
		
		System.out.println("getting the beans...");
		
//		Car car = context.getBean("getOnWheels", Car.class);
		Car car = context.getBean("dumped", Car.class);
		System.out.println(car);
		System.out.println(car.getName());
		
		Engine engine = context.getBean("blahBlah", Engine.class);
		System.out.println(engine);
		engine.startEngine();
		
		System.out.println(car.getEngine());
		car.getEngine().startEngine();
		
		/*Car car2 = context.getBean("car", Car.class);
		System.out.println(car2);
		System.out.println(car2.getEngine());
		
		Car car3 = context.getBean(Car.class);
		System.out.println(car3);
		System.out.println(car3.getEngine());
		
		Car lambo = context.getBean("futureCar", Car.class);
		System.out.println(lambo);
		System.out.println(lambo.getWheels());
		lambo.drive();
		
		Car bossy = context.getBean("getBossVehicle", Car.class);
		System.out.println(bossy);
		bossy.drive();
		System.out.println(bossy.getWheels());
*/		
		context.close();
	}

}
