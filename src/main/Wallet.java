package main;

public class Wallet {

	private double quantity;
	private String password;

	public Wallet(User user, double quantity) {
		this.quantity = quantity;
		this.password = user.getPassword();
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
