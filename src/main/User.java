package main;

import java.util.ArrayList;

public class User {
	public String username;
	private String password;
	private ArrayList<Transactions> transactions;
	
	public User() {
		this.username = null;
		this.password = null;
	}

	public User(String username, String password) {
		this.username = username;
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

	@Override
	public String toString() {
		return username;
	}
	
	
}
