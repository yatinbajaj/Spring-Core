package com.example.springcore;

import java.text.NumberFormat;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(InfraConfig.class)
public class AppConfig {
	@Bean(initMethod = "startGame", destroyMethod = "endGame")
	@Scope
	public Game game(DataSource dataSource) {
		BasketBallGame basketball =  new BasketBallGame(myRedSoxBean(),myRoyalsBean());
		basketball.setDs(dataSource);
		return basketball;
	}
	
	@Bean
	public NumberFormat nf() {
		return NumberFormat.getCurrencyInstance();
	}
	@Bean
	public Team myRedSoxBean() {
		return new RedSox();
	}
	@Bean
	public Team myRoyalsBean() {
		return new Royals();
	}
}
