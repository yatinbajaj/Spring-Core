package com.example.springcore;

//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringCoreOreillyApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Get Bean game which is an instance of a class that implements Game.
		Game game=appCtx.getBean("game",Game.class);
		System.out.println(game.playGame());
		
		Team royals = appCtx.getBean("myRoyalsBean",Team.class);
		Team redSox = appCtx.getBean("myRedSoxBean",Team.class);
		Team cubs   = appCtx.getBean("myCubs",Team.class);
		
		
		game.setAwayTeam(cubs);
		game.setHomeTeam(redSox);
		System.out.println(game.playGame());
		
		game.setAwayTeam(royals);
		game.setHomeTeam(redSox);
		System.out.println(game.playGame());
		
		appCtx.close();
		
	}

}
