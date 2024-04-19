package main;

public class User {
	public String username;
	protected String password;
	private String location;

	// i'll use it for creating a user to transfer money to
	public User() {
		this.username = "";
	}

	// general user creation
	public User(Bank bank, String username, String password) {
		this.username = username;
		this.password = password;
		this.location = bank.getLocation();
	}

	public User(String password) {
		this.password = password;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
