package main;

public class TransactionCrypto extends Transactions {

	@Override
	public boolean sendTo(Wallet walletRemitent, Wallet walletDestinatary, double amount) {
	    boolean transactionSuccess = false;

	    if (currencyValid(walletRemitent.getCurrency())) {
	        if (walletDestinatary.getCurrency() == walletRemitent.getCurrency()) {
	            if (walletRemitent.getWealth() >= amount) {
	                walletRemitent.setWealth(walletRemitent.getWealth() - amount);
	                walletDestinatary.setWealth(walletDestinatary.getWealth() + amount);
	                transactionSuccess = true;
	                System.out.println("transaction successful!");
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

}
