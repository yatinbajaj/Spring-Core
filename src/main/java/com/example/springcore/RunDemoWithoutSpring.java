package com.example.springcore;


public class RunDemoWithoutSpring {
	public static void main(String[] args) {
		Team team1 = new RedSox();
		Team team2 = new Royals();
		Game game = new BasketBallGame(team1,team2);
		System.out.println( game.playGame() );
	}
}
