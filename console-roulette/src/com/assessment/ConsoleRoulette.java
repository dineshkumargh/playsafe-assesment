package com.assessment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleRoulette {

	private static String player1 = "Tiki_Monkey";
	private static String player2 = "Barbara";
	private static Map<String, List<Betting>> map = new HashMap<>();

	public static void main(String[] args) {

		while (true) {

			Scanner in = new Scanner(System.in);
			System.out.println("\n Select player 1 or 2 \n 1. " + player1 + " \n 2. " + player2);
			int playerVal = in.nextInt();

			if (playerVal != 1 && playerVal != 2) {
				continue;
			}

			String playerName = selectBetType(playerVal);

			int nextInt = in.nextInt();

			if (nextInt != 1 && nextInt != 2 && nextInt != 3) {
				continue;
			}

			Betting betting = placeBet(in, nextInt);

		}

	}

	private static Betting placeBet(Scanner in, int nextInt) {
		Object val;
		if (nextInt == 1) {
			System.out.println("\n Enter the value - ");
			int newVal = in.nextInt();
			val = newVal;
		} else {
			val = nextInt == 2 ? BetValue.EVEN : BetValue.ODD;
		}

		System.out.println("\n Please enter the bet value \n");

		return new Betting(val, in.nextInt());

	}

	private static String selectBetType(int playerVal) {
		String playerName = player1;
		if (playerVal == 2) {
			playerName = player2;
		}

		System.out.println("\n Hello - " + playerName + " please place your bet \n");

		System.out.println(
				"\n Select among the following \n 1. Enter a number \n 2." + BetValue.EVEN + "\n 3. " + BetValue.ODD);
		return playerName;
	}

}
