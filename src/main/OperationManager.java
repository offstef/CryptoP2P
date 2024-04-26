package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class OperationManager {
	private ArrayList<User> allUsers = new ArrayList<>();
	private ArrayList<TransactionCrypto> cryptoTransactions = new ArrayList<>();
	private ArrayList<TransactionCurrency> currencyTransactions = new ArrayList<>();
	static Scanner input = new Scanner(System.in);

	// user options
	public void createUser() {
		try {
			User user = new User();
			System.out.print("What's your name: ");
			user.setUsername(input.nextLine());
			System.out.println("Set your password");
			user.setPassword(input.nextLine());
			allUsers.add(user);
			createWallets(user);
		} catch (Exception e) {
			System.err.println("Error creating user: " + e.getMessage());
			createUser();
		}
	}

	public void createWallets(User user) {
		Coin[] allCoins = Coin.values();
		Wallet[] userWallets = new Wallet[allCoins.length];

		for (int i = 0; i < allCoins.length; i++) {
			Wallet wallet = new Wallet(user, allCoins[i]);
			wallet.setWealth(10);
			userWallets[i] = wallet;
		}
		user.setUserWallets(userWallets);
		System.out.println("User's Wallets:");
		for (Wallet wallet : user.getUserWallets()) {
			System.out.println(wallet.getCurrency());
		}
	}

	public void seeUsers() {
		if (allUsers.isEmpty()) {
			System.out.println("No users created yet");
			System.out.println("Let's create one!!!");
			createUser();
		} else {
			for (User user : allUsers) {
				System.out.println(user);
			}
		}
	}

	public void deleteUser() {
		Iterator<User> iteratorUser = allUsers.iterator();
		boolean userDeleted = false;
		if (allUsers.isEmpty()) {
			System.out.println("there are no users created, go and create one");
		} else {
			System.out.println("So... you want to delete someone huh?");
			System.out.println("Then if his password and username are correct");
			System.out.println("I will delete that user, but it's permanentely deleted remeber");

			System.out.print("USERNAME: ");
			String name = input.nextLine();
			System.out.println("PASSWORD: ");
			String pass = input.nextLine();

			while (iteratorUser.hasNext()) {
				User user = iteratorUser.next();
				if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
					iteratorUser.remove();
					System.out.println("user " + user + " has been deleted");
					userDeleted = true;
					System.out.println("USER TABLE UPDATED");
					for (User user1 : allUsers) {
						System.out.println(user1);
					}
					break;
				}
			}
			if (!userDeleted) {
				System.out.println("user not found or password not correct");
			}
		}
	}

	// transaction options
	public void seeTransactions() {
		if (cryptoTransactions.isEmpty() && currencyTransactions.isEmpty()) {
			System.out.println("NOT A SINGLE TRANSACTION CREATED");
		} else if (cryptoTransactions.isEmpty()) {
			System.out.println("CURRENCY");
			for (TransactionCurrency currency : currencyTransactions) {
				System.out.println(currency);
			}
		} else if (currencyTransactions.isEmpty()) {
			System.out.println("CRYPTO");
			for (TransactionCrypto crypto : cryptoTransactions) {
				System.out.println(crypto);
			}
		} else {
			System.out.println("CURRENCY");
			for (TransactionCurrency currency : currencyTransactions) {
				System.out.println(currency);
			}
			System.out.println("CRYPTO");
			for (TransactionCrypto crypto : cryptoTransactions) {
				System.out.println(crypto);
			}
		}

	}

	public User[] userTransactionChecker() {
		User[] users = new User[2];
		// remitent check
		boolean remitentFound = false;
		System.out.println("Who is the remitent?");
		String remitentName = input.nextLine();

		for (User user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(remitentName)) {
				remitentFound = true;
				users[0] = user;
				break;
			}
		}

		if (remitentFound) {
			System.out.println("Remitent found! :)");
		} else {
			System.out.println("Remitent not found! :(");
			return null;
		}

		// destinatary check
		boolean destinataryFound = false;
		System.out.println("Who is the destinatary?");
		String destinataryName = input.nextLine();

		for (User user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(destinataryName)) {
				destinataryFound = true;
				users[1] = user;
				break;
			}
		}

		if (destinataryFound) {
			System.out.println("Destinatary found! :)");
			//
		} else {
			System.out.println("Destinatary not found! :(");
			return null;
		}
		return users;
	}

	private Wallet findWallet(User user, Coin coin) {
		Wallet[] userWallets = user.getUserWallets();
		for (Wallet wallet : userWallets) {
			if (wallet.getCurrency() == coin) {
				return wallet;
			}
		}
		return null;
	}

	public void cryptoTransaction() {

		User[] containerUsers = userTransactionChecker();

		System.out.println("For what coin do you want to make the transaction?");
		System.out.println("BTC");
		System.out.println("ETH");
		System.out.println("XRP");
		System.out.println("ADA");
		System.out.println("SOL");
		System.out.println("LTC");
		System.out.println("XMR");
		Coin coin = Coin.valueOf(input.nextLine());
		System.out.println("Enter the amount for the transaction:");
		double amount = input.nextDouble();
		input.nextLine();

		if (containerUsers != null) {
			User remitent = containerUsers[0];
			User destinatary = containerUsers[1];

			Wallet remitentWallet = findWallet(remitent, coin);
			Wallet destinataryWallet = findWallet(destinatary, coin);
			TransactionCrypto cryptoT = new TransactionCrypto(remitentWallet, destinataryWallet, amount);

			if (destinataryWallet != null && cryptoT.sendTo(remitentWallet, destinataryWallet, amount)) {
				System.out.println("Transaction completed successfully!");
				cryptoTransactions.add(cryptoT);
			} else {
				System.out.println("Transaction failed.");
			}
		}

	}

	public void currencyTransaction() {

		User[] containerUsers = userTransactionChecker();
		System.out.println("For what coin do you want to make the transaction?");
		System.out.println("USD");
		System.out.println("EUR");
		System.out.println("JPY");
		System.out.println("GBP");
		System.out.println("CHF");
		System.out.println("RUB");
		System.out.println("INR");
		Coin coin = Coin.valueOf(input.nextLine());
		System.out.println("Enter the amount for the transaction:");
		double amount = input.nextDouble();
		input.nextLine();

		if (containerUsers != null) {
			User remitent = containerUsers[0];
			User destinatary = containerUsers[1];
			Wallet remitentWallet = findWallet(remitent, coin);

			if (remitentWallet != null) {
				Wallet destinataryWallet = findWallet(destinatary, coin);
				TransactionCurrency currencyT = new TransactionCurrency(remitentWallet, destinataryWallet, amount);
				if (destinataryWallet != null && currencyT.sendTo(remitentWallet, destinataryWallet, amount)) {
					System.out.println("Transaction completed successfully!");
					currencyTransactions.add(currencyT);
				} else {
					System.out.println("Transaction failed.");
				}
			} else {
				System.out.println("Remitent wallet not found for the specified coin.");
			}
		}

	}

	// wallet options
	public void walletUser() {
		if (allUsers.isEmpty()) {
			System.out.println("No users created yet");
			System.out.println("Let's create one!!!");
			createUser();
		} else {
			System.out.print("Username: ");
			String name = input.nextLine();
			System.out.println("Password: ");
			String pass = input.nextLine();
			for (User user : allUsers) {
				if (user.getUsername().equalsIgnoreCase(name) && user.getPassword().equals(pass)) {
					Wallet[] userWallets = user.getUserWallets();
					for (Wallet wallet : userWallets) {
						System.out.println(wallet);
					}
				} else {
					System.out.println("AUTH FAILED!");
					walletUser();
				}
			}
		}
	}
}
