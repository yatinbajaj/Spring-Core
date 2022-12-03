package com.example.springcore;


public class RunDemoWithoutSpring {
	public static void main(String[] args) {
		Team team1 = new RedSox();
		Team team2 = new Royals();
		Team team3 = new Cubs();
		Game game = new BasketBallGame();
		
		game.setAwayTeam(team1);
		game.setHomeTeam(team2);
		System.out.println( game.playGame() );
		game.setAwayTeam(team1);
		game.setHomeTeam(team3);
		System.out.println( game.playGame() );
	}
}
