package main;

import java.time.LocalDate;

public class User extends Bank{
	public String username;
	protected String password;
	private String country;
	private LocalDate joined;

	// i'll use it for creating a user to transfer money to
	public User() {
		this.username = "";
	}
	// general user creation
	public User(String username, String password, String country) {
		this.username = username;
		this.password = password;
		this.country = country;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getJoined() {
		return joined;
	}

	public void setJoined(LocalDate joined) {
		this.joined = joined;
	}

}
