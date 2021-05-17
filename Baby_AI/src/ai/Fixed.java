package ai;

public class Fixed {

	private final String CREATOR = "Sk Sawlayetpar";
	private final String[] GREETING = { "What's up Dude ! ", "How may I help you ", "Go Ahead",
			"Yeap,I'm Listening :> ", "Hey Buddy " };
	private final String[] date = { "date", "calendar" };
	private final String[] time = { "time", "clock" };
	private final String[] timer = { "timer" };
	private final String[] user = { "first", "last", "full", "nick", "age" };
	private final String[] jokes = { "joke", "hilarious" };
	private final static String[] user_info = new String[5];

	public String getCREATOR() {
		return CREATOR;
	}

	public String[] getGREETING() {
		return GREETING;
	}

	public String getGreetingWord(int index) {
		return GREETING[index];
	}

	public String[] getDate() {
		return date;
	}

	public String getDateIndex(int index) {
		return date[index];
	}

	public String[] getTime() {
		return time;
	}

	public String getTimeIndex(int index) {
		return time[index];
	}

	public String[] getTimer() {
		return timer;
	}

	public String getTimerIndex(int index) {
		return timer[index];
	}

	public static String[] getUser() {
		return user_info;
	}

	public static String getUserInfo(String value) {
		if (value.contains("first")) {
			return user_info[0];
		} else if (value.contains("last")) {
			return user_info[1];
		} else if (value.contains("full")) {
			return user_info[2];
		} else if (value.contains("nick")) {
			return user_info[3];
		} else if (value.contains("age")) {
			return user_info[4];
		} else {
			return "Sorry";
		}
	}

	public static void setUserInfo(int index, String value) {
		user_info[index] = value;
	}

	public String[] user() {
		return user;
	}

	public String userIndex(int index) {
		return user[index];
	}

	public String[] joke() {
		return jokes;
	}

	public String jokeIndex(int index) {
		return jokes[index];
	}
}
