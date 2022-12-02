package com.example.springcore;

import javax.sql.DataSource;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BasketBallGame implements Game {
	private Team HomeTeam;
	private Team AwayTeam;
	private DataSource ds;
	
	public BasketBallGame() {}
	
	public BasketBallGame(Team homeTeam, Team awayTeam) {
		super();
		HomeTeam = homeTeam;
		AwayTeam = awayTeam;
	}
	
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	

	public DataSource getDs() {
		return ds;
	}
	
	@PostConstruct
	public void startGame() {
		System.out.println("Playing National Anthem");
	}
	
	@PreDestroy
	public void endGame() {
		System.out.println("Uploading whole recording of match on MLB");
	}

	public Team getHomeTeam() {
		return HomeTeam;
	}

	@Override
	public void setHomeTeam(Team homeTeam) {
		HomeTeam = homeTeam;
	}


	public Team getAwayTeam() {
		return AwayTeam;
	}


	public void setAwayTeam(Team awayTeam) {
		AwayTeam = awayTeam;
	}


	@Override
	public String playGame() {
		String name= Math.random() < 0.5 ? getHomeTeam().getName() : getAwayTeam().getName();
		return name;
	}


}
