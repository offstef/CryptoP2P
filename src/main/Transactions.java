package main;

public abstract class Transactions {
	protected Wallet remitentWallet;
    protected Wallet destinataryWallet;
    protected double amount;

	

	public Transactions(Wallet remitentWallet, Wallet destinataryWallet, double amount) {
		this.remitentWallet = remitentWallet;
		this.destinataryWallet = destinataryWallet;
		this.amount = amount;
	}

	public abstract boolean sendTo(Wallet walletRemitent, Wallet walletDestinatary, double amount);
	
	@Override
	public String toString() {
		if (remitentWallet != null && remitentWallet.getPropietary() != null &&
		        destinataryWallet != null && destinataryWallet.getPropietary() != null) {
		        
		        return remitentWallet.getPropietary().getUsername() + " sent " +
		               destinataryWallet.getPropietary().getUsername() + " " + amount;
		    } else {
		        return "Transaction details not available ";
		    }
	}

	
}
