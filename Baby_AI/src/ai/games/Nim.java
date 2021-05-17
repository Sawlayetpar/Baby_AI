package ai.games;

import java.util.Scanner;

import ai.user.Program_User;

public class Nim {

	private Scanner scanner = new Scanner(System.in);
	private int stone = 15;

	private int getInt(String str) {
		return Integer.parseInt(msg(str));
	}

	private String msg(String str) {
		System.out.print(str);
		return scanner.nextLine().toLowerCase().trim();
	}

	private int aiStrone() {
		int ai = (int) ((Math.random() * 2) + 1);
		if (stone == 1 || stone == 2) {
			return ai = 1;
		} else {
			return ai;
		}

	}

	public void start() {
		instruction();
		do {
			stone = 15;
			play();
		} while ("yes".equals(msg("Do u want to play again type yes,\nelse type anything to quit ")));
	}

	private void play() {
		String name = Program_User.getUser().getNick_name();
		while (true) {

			player_turn(name);
			if (stone == 0 || stone < 0) {
				System.out.println("You took the last stone,so you LOSE ");
				break;
			}

			int ai_stone = aiStrone();
			ai_turn(ai_stone);
			if (stone == 0 || stone < 0) {
				System.out.println("I have to take the last stone,so you WIN ");
				break;
			}
		}
	}

	private int player_turn(String name) {
		System.out.println(name + ",Now your turn.");
		System.out.println();
		stars();
		System.out.println();
		while (true) {
			int p_stone = getInt("How many stones do you want to remove? :");
			if (stone == 1 && p_stone == 2) {
				System.out.println("You can't take " + p_stone + ",there is only " + stone + " left");
				continue;
			} else if (p_stone < 1 || p_stone > 2) {
				System.out.println("invalid stone\nOnly you can take 2 or 1 stone");
				continue;

			} else {
				stone = stone - p_stone;
				break;
			}
		}
		return stone;
	}

	private int ai_turn(int ai) {
		System.out.println("It's my turn right now");
		System.out.println();
		stars();
		System.out.println();
		stone = stone - ai;
		if (ai == 1) {
			System.out.println("AI has taken " + ai + " stone ");
		} else {
			System.out.println("AI has taken " + ai + " stones ");
		}
		return stone;
	}

	private void stars() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= stone; i++) {
			sb.append("@ ");
		}
		System.out.println("Remaining Stone " + sb);
	}

	private void instruction() {
		System.out.println("WElCOME \nTO THE \nGAME OF NIM ");
		System.out.println("***INSTRUCTION***");
		System.out.println(
				"There are 15 stones in the pile.\nPlayers take turns taking stones.\nOn each turn,they can take one or two stones.\nThe player who takes the last stone is loser.\nHere stone is represented as  ' @ ' ");
	}
}
