package ai.games;

import java.util.Scanner;

public class TicTacToe {
	private Scanner scanner = new Scanner(System.in);

	public void start() {

		char[][] format = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		int count = 0;
		char[][] sym = new char[3][3];
		boolean end = false;
		instruction();
		while (end == false) {
			game(format);
			System.out.print("Enter 1 to 9 :");
			int player = scanner.nextInt();

			if (player > 9 || player < 1) {
				System.out.println("Invalid Position :( Try Again :) ");
				continue;
			}

			boolean contain = check(sym, player);
			while (contain) {
				System.out.println("Position has taken : ");
				System.out.print("Enter 1 to 9 :");
				player = scanner.nextInt();
				contain = check(sym, player);
			}

			position(player, format, sym, "player");
			count++;

			if (annoucement("player", sym, count).length() > 0) {
				System.out.println(annoucement("player", sym, count));
				System.out.println("Do u want to play again type yes,\nelse type anything to quit ");
				String user = scanner.next();
				if (user.equalsIgnoreCase("yes")) {
					loopAgain(sym);
					loopAgain(format);
					count = 0;
					continue;
				} else {
					end = true;
				}
			}

			System.out.println("***************************");

			int ai = (int) (Math.random() * 9 + 1);

			contain = check(sym, ai);
			while (contain) {
				ai = (int) (Math.random() * 9 + 1);
				contain = check(sym, ai);
			}

			System.out.println("AI took " + ai + " place ...");
			position(ai, format, sym, "ai");
			count++;

			if (annoucement("ai", sym, count).length() > 0) {
				System.out.println(annoucement("ai", sym, count));
				System.out.println("Do u want to play again type yes,\nelse type anything to quit ");
				String user = scanner.next();
				if (user.equalsIgnoreCase("yes")) {
					loopAgain(sym);
					loopAgain(format);
					count = 0;
					continue;
				} else {
					end = true;
				}
			}

			System.out.println("***************************");
		}
		System.out.println("See U Next Time");
	}

	private void instruction() {
		System.out.println("WELCOME \nTO THE \nGAME OF TIC TAC TOE ");
		System.out.println("***INSTRUCTION***");
		System.out.println(
				"There are 9 positions in this game.\nPlayers take turns taking stones.\nHere player's sign is 'X' and computer's sign is 'O'");
	}

	private void loopAgain(char[][] char_array) {
		for (int i = 0; i < char_array.length; i++) {
			for (int j = 0; j < char_array[i].length; j++) {
				if (char_array[i][j] == 'X' || char_array[i][j] == 'O') {
					char_array[i][j] = 0;
				}
			}
		}
	}

	private String annoucement(String user, char[][] sym, int count) {
		char sign = 'X';
		if (user.equals("player")) {
			sign = 'X';
		} else if (user.equals("ai")) {
			sign = 'O';
		}

		if ((sym[0][0] == sign) && (sym[0][1] == sign) && (sym[0][2] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}

		} else if ((sym[1][0] == sign) && (sym[1][1] == sign) && (sym[1][2] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}

		} else if ((sym[2][0] == sign) && (sym[2][1] == sign) && (sym[2][2] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}

		} else if ((sym[0][0] == sign) && (sym[1][0] == sign) && (sym[2][0] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}

		} else if ((sym[0][1] == sign) && (sym[1][1] == sign) && (sym[2][1] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}
		} else if ((sym[0][2] == sign) && (sym[1][2] == sign) && (sym[2][2] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}

		} else if ((sym[0][0] == sign) && (sym[1][1] == sign) && (sym[2][2] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}

		} else if ((sym[0][2] == sign) && (sym[1][1] == sign) && (sym[2][0] == sign)) {
			if (sign == 'X') {
				return "Congratulations you win ! ";
			} else if (sign == 'O') {
				return "Sorry AI Win :( ";
			}
		} else if (count == 9) {
			return "No One Win ";
		}

		return "";
	}

	private boolean check(char[][] sym, int value) {
		if (sym[0][0] != 0 && value == 1) {
			return true;

		} else if (sym[0][1] != 0 && value == 2) {
			return true;

		} else if (sym[0][2] != 0 && value == 3) {
			return true;

		} else if (sym[1][0] != 0 && value == 4) {
			return true;

		} else if (sym[1][1] != 0 && value == 5) {
			return true;

		} else if (sym[1][2] != 0 && value == 6) {
			return true;

		} else if (sym[2][0] != 0 && value == 7) {
			return true;

		} else if (sym[2][1] != 0 && value == 8) {
			return true;

		} else if (sym[2][2] != 0 && value == 9) {
			return true;
		}
		return false;
	}

	private void position(int position, char[][] format, char[][] sym, String user) {
		char sign = 'X';
		if (user.equals("player")) {
			sign = 'X';
		} else if (user.equals("ai")) {
			sign = 'O';
		}
		switch (position) {
		case 1:
			format[0][0] = sign;
			sym[0][0] = sign;
			game(format);
			break;

		case 2:
			format[0][2] = sign;
			sym[0][1] = sign;
			game(format);
			break;

		case 3:
			format[0][4] = sign;
			sym[0][2] = sign;
			game(format);
			break;

		case 4:
			format[2][0] = sign;
			sym[1][0] = sign;
			game(format);
			break;

		case 5:
			format[2][2] = sign;
			sym[1][1] = sign;
			game(format);
			break;

		case 6:
			format[2][4] = sign;
			sym[1][2] = sign;
			game(format);
			break;

		case 7:
			format[4][0] = sign;
			sym[2][0] = sign;
			game(format);
			break;

		case 8:
			format[4][2] = sign;
			sym[2][1] = sign;
			game(format);
			break;

		case 9:
			format[4][4] = sign;
			sym[2][2] = sign;
			game(format);
			break;
		}

	}

	private void game(char[][] format) {
		System.out.println();
		for (char[] ch : format) {
			for (char c : ch) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}
