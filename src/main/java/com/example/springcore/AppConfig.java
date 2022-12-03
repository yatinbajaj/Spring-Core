package com.example.springcore;

import java.text.NumberFormat;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import aspect.LoggingAspect;

@Configuration
@Import(InfraConfig.class)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.example")
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
	@Bean
	public Team myCubs() {
		return new Cubs();
	}
	@Bean
	public LoggingAspect myLogging() {
		return new LoggingAspect();
	}
}
