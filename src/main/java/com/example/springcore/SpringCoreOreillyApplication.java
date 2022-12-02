package com.example.springcore;

import java.text.NumberFormat;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringCoreOreillyApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
		// Get Bean game which is an instance of a class that implements Game.
		Game game=appCtx.getBean("game",Game.class);
		System.out.println(game.playGame());
		
		System.out.println("Total Number of Bean inside context: " + appCtx.getBeanDefinitionCount());
		for(String name : appCtx.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		
		// Number Format abstract class instantiation
		NumberFormat nf=appCtx.getBean(NumberFormat.class);
		double amount = 1345678.9012345;
		System.out.println(nf.format(amount));
		
		appCtx.close();
		
	}

}
