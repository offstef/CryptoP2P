package main;

public abstract class Transactions {
	protected User remitent;
	protected User destinatary;
	public abstract void sendTo(User remitent, User destinatary);
}
