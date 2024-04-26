package main;

public class Wallet {
	private User propietary;
	private double wealth;
	public Coin currency;

	public Wallet(User propietary, Coin coin) {
		this.propietary = propietary;
		this.wealth = 0.0;
		this.currency = coin;
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

	public Coin getCurrency() {
		return currency;
	}

	public void setCurrency(Coin currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "" + wealth + " " + currency;
	}

}
