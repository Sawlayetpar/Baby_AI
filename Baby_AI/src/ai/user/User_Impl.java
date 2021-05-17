package ai.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ai.Common;
import ai.Fixed;

public class User_Impl {

	private final String FOLDER_PATH = Common.getPath();
	private final String USER = "\\user.data";
	private final String FILE_PATH = FOLDER_PATH.concat(USER);
	private final User user = new User();
	private Scanner scanner;

	private void createFolder(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		hide(file);
	}

	private void hide(File folder) {
		try {
			Process p = Runtime.getRuntime().exec("attrib +h " + folder.getPath());
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void createFile(String path) {
		File file = new File(path);
		File folder = new File(FOLDER_PATH);
		if (!folder.exists()) {
			folder.mkdir();
			hide(folder);
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void create_user() {
		File file = new File(FILE_PATH);

		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			System.out.println("Fill the instruction to continue : ");

			System.out.print("Your First Name : ");
			String first_name = Common.user_string();
			user.setFirst_name(first_name);

			System.out.print("Your Last Name : ");
			String last_name = Common.user_string();
			user.setLast_name(last_name);

			System.out.println();
			user.setFull_name();
			System.out.print("Your Full Name is " + user.getFull_name());

			System.out.print(" \nYour nick name or how should I Call You ? ");
			String nick_name = Common.user_string();
			user.setNick_name(nick_name);

			System.out.print("Your Age : ");
			int age = Common.user_int();
			user.setAge(age);

			outputStream.writeObject(user);
			outputStream.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getUser() {
		File file = new File(FILE_PATH);
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
			User user = (User) inputStream.readObject();

			Program_User.setUser(user);
			String first_name = user.getFirst_name();
			String last_name = user.getLast_name();
			String full_name = user.getFull_name();
			String nick_name = user.getNick_name();
			int age = user.getAge();

			int len = Fixed.getUser().length;
			for (int i = 0; i < len; i++) {
				if (i == 0) {
					Fixed.setUserInfo(i, first_name);
				} else if (i == 1) {
					Fixed.setUserInfo(i, last_name);
				} else if (i == 2) {
					Fixed.setUserInfo(i, full_name);
				} else if (i == 3) {
					Fixed.setUserInfo(i, nick_name);
				} else if (i == 4) {
					Fixed.setUserInfo(i, String.valueOf(age));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		createFolder(FOLDER_PATH);
		createFile(FILE_PATH);
		File file = new File(FILE_PATH);
		if (file.exists()) {
			try {
				scanner = new Scanner(file);
				int count = 0;
				while (scanner.hasNext()) {
					count++;
					if (count > 10) {
						break;
					}
				}
				if (count == 0) {
					create_user();
				} else {
					getUser();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
