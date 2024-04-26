package main;

public abstract class Transactions {
	protected User remitent;
	protected User destinatary;

	public abstract boolean sendTo(Wallet walletRemitent, Wallet walletDestinatary, double amount);

	@Override
	public String toString() {
		return remitent.getUsername() + " sent to " + destinatary.getUsername();
	}
	
}
