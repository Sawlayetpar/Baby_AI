package ai.program;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Date_Time {

	public void currentDate() {
		LocalDate date = LocalDate.now();
//		System.out.println(date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear());
		if (date.getDayOfMonth() < 4) {
			if (date.getDayOfMonth() == 1) {
				System.out.println("The " + date.getDayOfMonth() + "st of " + Month.of(date.getMonthValue()) + ","
						+ date.getYear());
			} else if (date.getDayOfMonth() == 2) {
				System.out.println("The " + date.getDayOfMonth() + "nd of " + Month.of(date.getMonthValue()) + ","
						+ date.getYear());
			} else {
				System.out.println("The " + date.getDayOfMonth() + "rd of " + Month.of(date.getMonthValue()) + ","
						+ date.getYear());
			}
		} else {
			System.out.println(
					"The " + date.getDayOfMonth() + "th of " + Month.of(date.getMonthValue()) + "," + date.getYear());
		}
	}

	public void currentTime() {
		LocalTime time = LocalTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm a");
		System.out.println(time.format(df));
	}
}
