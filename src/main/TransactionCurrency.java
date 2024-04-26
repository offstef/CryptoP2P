package main;

public class TransactionCurrency extends Transactions {

	public TransactionCurrency(Wallet remitentWallet, Wallet destinataryWallet, double amount) {
		super(remitentWallet, destinataryWallet, amount);
	}

	/**
	 * Transfers a specified amount from one wallet to another
	 * 
	 * @param walletRemitent    the wallet sending the amount
	 * @param walletDestinatary the wallet receiving the amount
	 * @param amount            the amount to transfer
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
					System.out.println("transaction successful!");
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
		return currency == Coin.USD || currency == Coin.EUR || currency == Coin.GBP || currency == Coin.JPY
				|| currency == Coin.CHF || currency == Coin.RUB || currency == Coin.INR;
	}

	@Override
	public String toString() {
		return super.toString() + " of some type of normal currency";
	}

}
