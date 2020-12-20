package com.assessment;

import java.util.Scanner;

public class ConsoleRoulette {

	private static String player1 = "Tiki_Monkey";
	private static String player2 = "Barbara";
	
	public static void main(String[] args) {
		
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("\n Select player 1 or 2 \n 1. "+player1+" \n 2. "+player2);
			int playerVal = in.nextInt();
			
			if(playerVal != 1 && playerVal != 2) {
				continue;
			}
			
			String playerName = player1;
			if(playerVal == 2) {
				playerName = player2;
			}
			
			System.out.println("\n Hello - "+playerName+" please place your bet \n");
			
			
			
		
		}
		
	}
	
}
