package ai;

import java.io.File;

import ai.credit.Credit;
import ai.games.Nim;
import ai.games.TicTacToe;
import ai.joke.Fixed_Jokes;
import ai.joke.Joke_Impl;
import ai.program.Date_Time;
import ai.program.Timer;
import ai.user.User_Impl;

public class Controller {

	private Fixed fixed;

	private Date_Time date_time;
	private String[] words;
	private Nim nim;
	private TicTacToe toe;
	private User_Impl user_file;
	private Fixed_Jokes joke;
	private Joke_Impl joke_Impl;
	private Credit credit;

	public void start() {
		fixed = new Fixed();
		date_time = new Date_Time();
		nim = new Nim();
		toe = new TicTacToe();
		user_file = new User_Impl();
		joke = new Fixed_Jokes();
		joke_Impl = new Joke_Impl();
		credit = new Credit();
		message();
	}

	private void greeting() {
		int len = fixed.getGREETING().length;
		int random = (int) (Math.random() * len);
		System.out.println(fixed.getGreetingWord(random));
	}

	private void message() {
		File file = new File(Common.getPath());
		if (!file.exists()) {
			start_only();
		} else {
			user_file.start();
			while (true) {
				greeting();
				String user = Common.getString();
				words = user.split(" ");
				for (int w = 0; w < words.length; w++) {

					for (int d = 0; d < fixed.getDate().length; d++) {
						if (words[w].contains(fixed.getDateIndex(d))
								&& words[w].equalsIgnoreCase(fixed.getDateIndex(d))) {
							date_time.currentDate();
						}
					}

					for (int t = 0; t < fixed.getTime().length; t++) {
						if (words[w].contains(fixed.getTimeIndex(t))
								&& words[w].equalsIgnoreCase(fixed.getTimeIndex(t))) {
							date_time.currentTime();
						}
					}

					for (int tr = 0; tr < fixed.getTimer().length; tr++) {
						if (words[w].contains(fixed.getTimerIndex(tr))
								&& words[w].equalsIgnoreCase(fixed.getTimerIndex(tr))) {
							doTimer();
						}
					}

					for (int u = 0; u < fixed.user().length; u++) {
						try {
							if (words[w].contains(fixed.userIndex(u))) {
								if (words[w].equals("age")) {
									System.out.println(Fixed.getUserInfo(words[w]));
								} else if (words[w + 1].equals("name")) {
									System.out.println(Fixed.getUserInfo(words[w]));
								}
							} else if ((words[w].contains("name") && words[w - 1].contains("my"))
									|| (words[w].equals("name") && words[w - 1].equals("my"))) {
								getInfo("two");
								break;
							}
						} catch (Exception e) {
							System.out.println("I can't help you with that");
							break;
						}
					}

					for (int j = 0; j < fixed.joke().length; j++) {
						if (words[w].contains(fixed.jokeIndex(j))) {
							if (words[w].equalsIgnoreCase("jokes") || words[w].equalsIgnoreCase("")) {
								joke.joke();
							}
							joke.joke();
						}
					}

					if (words[w].contains("game") && words[w].equals("game")) {
						games();
					}

					if (words[w].contains("creator") && words[w].equals("creator")) {
						System.out.println(fixed.getCREATOR());
					}

					if (words[w].contains("credit") && words[w].equals("credit")) {
						credit.start("credit");
					}

					if (words[w].contains("help") && words[w].equals("help")) {
						credit.start("ability");
					}
					if (words[w].contains("quit") || words[w].contains("exit")) {
						System.out.println("BYE BYE");
						System.exit(0);
					}

				}
				System.out.println();
			}

		}
	}

	private void getInfo(String str) {
		if (str.equalsIgnoreCase("one")) {

		} else if (str.equalsIgnoreCase("two")) {

			System.out.println("which name ");
			for (int u = 0; u < fixed.user().length; u++) {
				if (!fixed.userIndex(u).equalsIgnoreCase("age")) {
					System.out.print(fixed.userIndex(u) + " | ");
				}
			}
			String user = Common.getString();
			System.out.println(Fixed.getUserInfo(user));
		}

	}

	private void doTimer() {
		int hour = 0;
		int minute = 0;
		int seconds = 0;
		char[] hr = { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' };
		char[] min = { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' };
		char[] sec = { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' };
		for (int loop = 0; loop < words.length; loop++) {
			String str = words[loop];
			if (str != null) {
				if (str.contains("minute") || str.contains("minutes")) {
					char[] char_time = str.toCharArray();

					if (Character.isDigit(char_time[0])) {
						for (int i = 0; i < char_time.length; i++) {
							if (Character.isDigit(char_time[i]))
								min[i] = char_time[i];
						}

						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < min.length; i++) {
							if (Character.isDigit(min[i]))
								builder.append(min[i]);
						}
						minute = Integer.parseInt(builder.toString());
					} else {
						char[] minute_digit = words[loop - 1].toCharArray();
						for (int i = 0; i < minute_digit.length; i++) {
							if (Character.isDigit(minute_digit[i]))
								min[i] = minute_digit[i];
						}

						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < min.length; i++) {
							if (Character.isDigit(min[i]))
								builder.append(min[i]);
						}
						minute = Integer.parseInt(builder.toString());
					}

				} else if (str.contains("second") || str.contains("seconds")) {
					char[] char_time = str.toCharArray();

					if (Character.isDigit(char_time[0])) {
						for (int i = 0; i < char_time.length; i++) {
							if (Character.isDigit(char_time[i]))
								sec[i] = char_time[i];
						}

						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < sec.length; i++) {
							if (Character.isDigit(sec[i]))
								builder.append(sec[i]);
						}

						seconds = Integer.parseInt(builder.toString());
					} else {

						char[] second_digit = words[loop - 1].toCharArray();
						for (int i = 0; i < second_digit.length; i++) {
							if (Character.isDigit(second_digit[i]))
								sec[i] = second_digit[i];
						}

						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < sec.length; i++) {
							if (Character.isDigit(sec[i]))
								builder.append(sec[i]);
						}
						seconds = Integer.parseInt(builder.toString());
					}
				}

				else if (str.contains("hour") || str.contains("hours")) {
					char[] char_time = str.toCharArray();

					if (Character.isDigit(char_time[0])) {
						for (int i = 0; i < char_time.length; i++) {
							if (Character.isDigit(char_time[i]))
								hr[i] = char_time[i];
						}

						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < hr.length; i++) {
							if (Character.isDigit(hr[i]))
								builder.append(hr[i]);
						}

						hour = Integer.parseInt(builder.toString());
					} else {

						char[] hour_digit = words[loop - 1].toCharArray();
						for (int i = 0; i < hour_digit.length; i++) {
							if (Character.isDigit(hour_digit[i]))
								hr[i] = hour_digit[i];
						}

						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < hr.length; i++) {
							if (Character.isDigit(hr[i]))
								builder.append(hr[i]);
						}
						hour = Integer.parseInt(builder.toString());
					}
				}
			}
		}

		Timer.start(hour, minute, seconds);
	}

	private void games() {
		int random = (int) (Math.random() * 2 + 1);
		switch (random) {
		case 1:
			nim.start();
			break;
		case 2:
			toe.start();
			break;

		default:
			break;
		}
	}

	private void start_only() {
		user_file.start();
		joke_Impl.start();
		System.out.println("Success");
		System.out.println("\n");
		credit.start("ability");
	}
}
