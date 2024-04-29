package main;

public class TransactionCrypto extends Transactions {

	public TransactionCrypto(Wallet remitentWallet, Wallet destinataryWallet, double amount) {
		super(remitentWallet, destinataryWallet, amount);
		this.amount = amount;
	}

	/**
	 * Transfers a specified amount from one wallet to another
	 * 
	 * @param walletRemitent the wallet sending the amount
	 * @param walletDestinatary the wallet receiving the amount
	 * @param amount the amount to transfer
	 * @return true if the transaction is successful, false otherwise
	 */
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
			System.out.println("invalid currency");
		}

		return transactionSuccess;
	}

	/**
	 * Checks if a given currency is valid for transactions.
	 * 
	 * @param currency the currency to check
	 * @return true if the currency is valid, false otherwise
	 */
	private boolean currencyValid(Coin currency) {
		return currency == Coin.BTC || currency == Coin.ETH || currency == Coin.XRP || currency == Coin.ADA
				|| currency == Coin.SOL || currency == Coin.LTC || currency == Coin.XMR;
	}

	@Override
	public String toString() {
		return super.toString() + " of some type of crypto";
	}

}
