package model;

import java.util.regex.Pattern;

public class UserError {
	
	private String name;
	private String passWord;
	private String email;
	private String error;
	
	
	public UserError(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	
	public UserError(String name, String passWord, String email) {
		super();
		this.name = name;
		this.passWord = passWord;
		this.email = email;
	}
	
	public UserError() {
		this.name = "";
		this.passWord = "";
		this.email = "";
	}

	
	private static final String REGEX_PATTERN = "^(.+)@(\\S+)$";
	
	public static boolean validate(String emailAddress) {
        return Pattern.compile(REGEX_PATTERN)
                .matcher(emailAddress)
                .matches();
    }
	
	@Override
	public String toString() {
		return this.name + " " +this.passWord + " " +this.email;
	}
	
	
}
