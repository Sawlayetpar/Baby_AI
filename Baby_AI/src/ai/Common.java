package ai;

import java.util.Scanner;

public class Common {

	private static Scanner scanner = new Scanner(System.in);
	private static final int NUMBER_OF_JOKES = 2;

	public static int getNumberOfJokes() {
		return NUMBER_OF_JOKES;
	}

	public static String getPath() {
		String path = "C:\\Users\\";
		String user_name = System.getProperty("user.name");
		String folder = path.concat(user_name + "\\Baby_Ai");
		return folder;
	}

	public static String getString() {
		return scanner.nextLine().toLowerCase().trim();
	}

	public static String user_string() {
		return scanner.nextLine().trim();
	}

	public static int user_int() {
		return Integer.parseInt(scanner.next().trim());
	}
}
