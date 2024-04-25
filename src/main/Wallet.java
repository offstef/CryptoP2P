package main;

public class Wallet {
	private User propietary;
	private double wealth;
	private String password;
	public Coin currency;

	public Wallet(User propietary, Coin coin) {
		this.propietary = propietary;
		this.wealth = 0.0;
		this.password = propietary.getPassword();
	}

	public User getPropietary() {
		return propietary;
	}

	public void setPropietary(User propietary) {
		this.propietary = propietary;
	}

	public double getWealth() {
		return wealth;
	}

	public void setWealth(double wealth) {
		this.wealth = wealth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Coin getCurrency() {
		return currency;
	}

	public void setCurrency(Coin currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Wallet [propietary=" + propietary + ", wealth=" + wealth + ", password=" + password + ", currency="
				+ currency + "]";
	}

	

}
