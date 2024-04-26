package main;

public abstract class Transactions {
	protected Wallet remitentWallet;
	protected Wallet destinataryWallet;
	protected double amount;

	public Transactions(Wallet remitentWallet, Wallet destinataryWallet, double amount) {
		this.remitentWallet = remitentWallet;
		this.destinataryWallet = destinataryWallet;
		this.amount = 0;
	}

	/**
	 * Abstract method to transfer a specified amount from one wallet to another
	 * 
	 * @param walletRemitent the wallet sending the amount
	 * @param walletDestinatary the wallet receiving the amount
	 * @param amount the amount to transfer
	 * @return true if the transaction is successful, false otherwise
	 */
	public abstract boolean sendTo(Wallet walletRemitent, Wallet walletDestinatary, double amount);

	/**
	 * Returns a string representation of the transaction details
	 * 
	 * @return a string containing transaction details
	 */
	@Override
	public String toString() {
		if (remitentWallet != null && remitentWallet.getPropietary() != null && destinataryWallet != null
				&& destinataryWallet.getPropietary() != null) {

			return remitentWallet.getPropietary().getUsername() + " sent "
					+ destinataryWallet.getPropietary().getUsername() + " " + amount;
		} else {
			return "Transaction details not available ";
		}
	}

}
