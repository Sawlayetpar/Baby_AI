package ai.joke;

public class Joke {

	private String question;
	private String answer;

	public Joke(String[] arr) {
		this.question = arr[0];
		this.answer = arr[1];
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
