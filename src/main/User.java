package main;

public class User {
	public String username;
	private String password;
	public Wallet[] userWallets;

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

	public Wallet[] getUserWallets() {
		return userWallets;
	}

	public void setUserWallets(Wallet[] userWallets) {
		this.userWallets = userWallets;
	}

	@Override
	public String toString() {
		return username;
	}

}
