package main;

public class Wallet {
	private User propietary;
	private double wealth;
	private String password;
	public Coin currency;
	
	public Wallet(User propietary, Coin currency) {
		this.propietary = propietary;
		this.wealth = 0.0;
		this.password = propietary.getPassword();
		this.currency = currency;
	}
	
	

}
