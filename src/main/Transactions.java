package main;

public abstract class Transactions {
	protected User remitent;
	protected User destinatary;

	public abstract void sendTo(User remitent, User destinatary, Wallet walletRemitent, Wallet walletDestinatary, double amount);

	@Override
	public String toString() {
		return remitent.getUsername() + " sent to " + destinatary.getUsername();
	}
	
}
