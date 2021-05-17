package ai.joke;

public class Fixed_Jokes {

	private final String[] question = { "what do you call an alligator in a vest",
			"why did the banana go to the doctor", "what do you call a sleeping bull",
			"when is the best time to go the dentist", "what has four wheels and flies",
			"what do you call a bear with no teeth", "why do golfers have two pairs of pants", "why was 6 afraid of 7",
			"why are pirates called pirates", "what do you call a fly with no wings",
			"what gets more wet the more it dries" };

	private final String[] answer = { "an investigator", "it did not peel weel", "a bulldozer", "at toot-hurty",
			"a garbage truck", "a gummy bear", "in case they get a hole in one", "because 7,8,9", "because they arrrrr",
			"a walk", "a towel" };

	private Joke_Impl joke_Impl;

	public Fixed_Jokes() {
		joke_Impl = new Joke_Impl();
	}

	public void joke() {
		int random = (int) (Math.random() * 2 + 1);
		switch (random) {
		case 1: 
			
			int index = (int) (Math.random() * answer.length);
			System.out.println(question[index] + "?\n\t" + answer[index] + "!");
			break;

		case 2:
			joke_Impl.start();
			break;

		}
	}
}
