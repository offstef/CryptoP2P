package main;

public class TransactionCrypto extends Transactions {

	@Override
	public void sendTo(User remitent, User destinatary, Wallet walletRemitent, Wallet walletDestinatary, double amount) {
		if (walletRemitent.getCurrency() == Coin.BTC || walletRemitent.getCurrency() == Coin.ETH 
	            || walletRemitent.getCurrency() == Coin.XRP || walletRemitent.getCurrency() == Coin.ADA 
	            || walletRemitent.getCurrency() == Coin.SOL || walletRemitent.getCurrency() == Coin.LTC 
	            || walletRemitent.getCurrency() == Coin.XMR) {

	        if (walletDestinatary.getCurrency() == walletRemitent.getCurrency()) {
	            if (walletRemitent.getWealth() >= amount) {
	                walletRemitent.setWealth(walletRemitent.getWealth() - amount);
	                walletDestinatary.setWealth(walletDestinatary.getWealth() + amount);
	                System.out.println("Transaction successful!");
	            } else {
	                System.out.println("Insufficient funds in remitent's wallet.");
	            }
	        } else {
	            System.out.println("Remitent and destinatary wallets have different currencies.");
	        }
	    } else {
	        System.out.println("Invalid currency in remitent's wallet.");
	    }

	}

}
