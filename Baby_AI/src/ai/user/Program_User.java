package ai.user;

public final class Program_User {

	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Program_User.user = user;
	}

}
