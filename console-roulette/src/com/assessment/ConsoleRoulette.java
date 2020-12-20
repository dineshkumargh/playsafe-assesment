package com.assessment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.BiConsumer;

public class ConsoleRoulette {

	private static String player1 = "Tiki_Monkey";
	private static String player2 = "Barbara";
	private static Map<String, List<Betting>> map = new HashMap<>();

	public static void main(String[] args) {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (map.isEmpty()) {
					System.out.println("\n No bets placed in the last round \n");
					return;
				}

				BiConsumer<String, List<Betting>> consumer = (a, b) -> {
					int val = 0;
					for (Betting betting : b) {
						if (betting.getBetValue() instanceof BetValue) {
							val += betting.getValue() * 2;
						} else if (betting.getValue() > 0 && betting.getValue() < 37) {
							val += (betting.getValue() * 36);
						}
					}
					System.out.println("\n Bet amount won by player - " + a + " \n " + val);
				};
				map.forEach((k, v) -> consumer.accept(k, v));
				map.clear();

			}
		}, 30000);

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

			map.computeIfAbsent(playerName, e -> new ArrayList<>());

			map.get(playerName).add(betting);

			int betResultValue = 0;
			String result = "WIN";
			if (!(betting.getBetValue() instanceof BetValue) && (betting.getValue() < 0 || betting.getValue() > 36)) {
				result = "LOSE";
			} else if (betting.getBetValue() instanceof BetValue) {
				betResultValue = betting.getValue() * 2;
			} else {
				betResultValue = betting.getValue() * 36;
			}

			System.out.println("\n Player bet outcome winnings \n");
			System.out.println(playerName + " - " + result + "  " + betResultValue + " \n");

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
