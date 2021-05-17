package ai.credit;

public class Credit {

	private final String credit = "What's up buddy\r\n"
			+ "I'm the program who is going tell you about the credit of this program\r\n"
			+ "I'm Baby AI version 1.0\r\n" + "I've been programed by Sk Sawlayetpar, father of this program\r\n"
			+ "Sk Sawlayetpar create me to develop his skill\r\n"
			+ "I've been started to code on the first of February, 2021\r\n"
			+ "My version 1.0,have been released on the 20th of February,2021\r\n"
			+ "It's feel like I was born on the 20th of February,2021\r\n" + "You can take it as my first birthday";

	private final String ability = "I can help you using this program as mention as below\r\n" + "|\r\n" + "|\r\n"
			+ "V \r\n" + "\r\n" + "(1) I can tell you Date of now\r\n" + "(2) I can tell you Time of now\r\n"
			+ "(3) I can make you fun by telling jokes\r\n" + "(4) I can set timer for you\r\n"
			+ "(5) We can play game";

	private void read(String str) {
		String[] array = str.split(" ");
		for (String s : array) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.print(s + " ");
		}
	}
	
	public void start(String string) {
		if(string.equalsIgnoreCase("credit")) {
			read(credit);
		}else if(string.equalsIgnoreCase("ability")) {
			read(ability);
		}
	}
}
