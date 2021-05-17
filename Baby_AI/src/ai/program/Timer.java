package ai.program;

public class Timer {

	private static int hmsToseconds(int h, int m, int s) {
		int hToseconds = h * 3600;
		int mToseconds = m * 60;
		int total = hToseconds + mToseconds + s;
		return total;
	}

	public static void start(int hours, int minutes, int seconds) {
		int currentSeconds = hmsToseconds(hours, minutes, seconds);
		currentSeconds = currentSeconds * 1000;
		try {
			System.out.println("Don't quit the program,type nothing and stay ");
			Thread.sleep(currentSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Time Out Your Timer");
		}

	}
}
