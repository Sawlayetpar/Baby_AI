package ai.joke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ai.Common;

public class Joke_Impl {

	private final String FOLDER_PATH = Common.getPath();
	private final String FILE_NAME = "\\joke.dat";
	private final String FILE_PATH = FOLDER_PATH.concat(FILE_NAME);
	private List<Joke> jokes;
	private final Map<Integer, String> question = new HashMap<>();
	private final Map<Integer, String> answer = new HashMap<>();
	private int numberOfJokes = Common.getNumberOfJokes();

	private void create_folder() {
		File folder = new File(FOLDER_PATH);
		if (!folder.exists()) {
			folder.mkdir();
		}
	}

	private File create_file() {
		File file = new File(FILE_PATH);
		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	private void create_joke() {
		try {
			jokes = Files.readAllLines(Paths.get(FILE_PATH)).stream().skip(0).filter(line -> line.length() > 0)
					.filter(line -> line.contains("\t")).map(line -> line.split("\t")).filter(arr -> arr.length > -1)
					.map(Joke::new).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> q = jokes.stream().map(j -> j.getQuestion()).collect(Collectors.toList());
		List<String> a = jokes.stream().map(j -> j.getAnswer()).collect(Collectors.toList());

		String[] que = new String[q.size()];
		String[] ans = new String[a.size()];

		q.toArray(que);
		a.toArray(ans);

		for (int i = 0; i < que.length; i++) {
			question.put(i, que[i]);
			answer.put(i, ans[i]);
		}

		int random = (int) (Math.random() * que.length);
		System.out.println(question.get(random) + "?\n\t" + answer.get(random) + "!");
	}

	private File getJokeFile() {
		boolean file_exist = false;
		Scanner scanner = new Scanner(System.in);
		while (file_exist == false) {
			System.out.println("Enter the joke file path below :: ");
			String path = scanner.nextLine();

			File file = new File(path);
			if (file.exists()) {
				scanner.close();
				return file;
			} else {
				continue;
			}
		}
		scanner.close();
		return null;
	}

	private void copyJokeData() {
		File joke_file = getJokeFile();
		try (BufferedReader reader = new BufferedReader(new FileReader(joke_file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		create_folder();
		create_file();
		long lineCount = 0;
		try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {
			lineCount = stream.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lineCount > numberOfJokes) {
			create_joke();
		} else {
			copyJokeData();
		}
	}

}
