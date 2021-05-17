package ai.user;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String first_name;
	private String last_name;
	private String full_name;
	private String nick_name;
	private int age;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name() {
		this.full_name = first_name + " " + last_name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void write(ObjectOutput output) {
		try {
			output.writeUTF(first_name);
			output.writeUTF(last_name);
			output.writeUTF(full_name);
			output.writeUTF(nick_name);
			output.write(age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void read(ObjectInput input) {
		try {
			first_name = input.readUTF();
			last_name = input.readUTF();
			full_name = input.readUTF();
			nick_name = input.readUTF();
			age = input.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
