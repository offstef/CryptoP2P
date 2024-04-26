package main;

public class TransactionCrypto extends Transactions {
	
	
	public TransactionCrypto(Wallet remitentWallet, Wallet destinataryWallet, double amount) {
		super(remitentWallet, destinataryWallet, amount);
	}
	@Override
	public boolean sendTo(Wallet walletRemitent, Wallet walletDestinatary, double amount) {
	    boolean transactionSuccess = false;

	    if (currencyValid(walletRemitent.getCurrency())) {
	        if (walletDestinatary.getCurrency() == walletRemitent.getCurrency()) {
	            if (walletRemitent.getWealth() >= amount) {
	                walletRemitent.setWealth(walletRemitent.getWealth() - amount);
	                walletDestinatary.setWealth(walletDestinatary.getWealth() + amount);
	                transactionSuccess = true;
	            } else {
	                System.out.println("remitent doesnt have that much money");
	            }
	        } else {
	            System.out.println("remitent and destinatary wallets have different currencies");
	        }
	    } else {
			System.out.println("remitent invalid currency");
	    }

	    return transactionSuccess;
	}
	private boolean currencyValid(Coin currency) {
	    return currency == Coin.BTC || currency == Coin.ETH || currency == Coin.XRP 
	           || currency == Coin.ADA || currency == Coin.SOL || currency == Coin.LTC 
	           || currency == Coin.XMR;
	}
	@Override
	public String toString() {
		return super.toString() + " of crypto";
	}

}
