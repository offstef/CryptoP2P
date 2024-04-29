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

	/**
	 * Prompts to create a new user with a unique username and password, validates
	 * the input, and adds the user with associated wallets
	 * 
	 * If input validation fails, the method retries until valid input is provided
	 */
	public void createUser() {
		try {
			User user = new User();
			System.out.print("What's your name: ");
			String username = input.nextLine();

			if (isUsernameTaken(username)) {
				System.out.println("Username already exists");
				createUser();
			}
			user.setUsername(username);

			if (user.getUsername().length() < 5) {
				System.err.println("Username to short, min 5 characters");
				createUser();
				return;
			}
			System.out.print("Set your password: ");
			user.setPassword(input.nextLine());
			if (user.getPassword().length() < 8) {
				System.err.println("to short.. min 8 characters");
				createUser();
				return;
			}
			allUsers.add(user);
			createWallets(user);
		} catch (Exception e) {
			System.err.println("Error creating user :( " + e.getMessage());
			createUser();
		}
	}

	/**
	 * Checks if a username is already taken by looping through existing users
	 * 
	 * @param username the username to check for availability
	 * @return true if the username is already taken
	 */
	private boolean isUsernameTaken(String username) {
		for (User user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates walletsand initializes each wallet with a starting wealth of 10
	 * coins.
	 * 
	 * @param user for assigning the wallets to him
	 */
	public void createWallets(User user) {
		Coin[] allCoins = Coin.values();
		Wallet[] userWallets = new Wallet[allCoins.length];

		for (int i = 0; i < allCoins.length; i++) {
			Wallet wallet = new Wallet(user, allCoins[i]);
			wallet.setWealth(10);
			userWallets[i] = wallet;
		}
		user.setUserWallets(userWallets);
		/*
		 * System.out.println("User's Wallets:"); for (Wallet wallet :
		 * user.getUserWallets()) { System.out.println(wallet.getCurrency()); }
		 */
	}

	/**
	 * Displays information about all users If no users exist, prompts the creation
	 * of a new user
	 */
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

	/**
	 * Deletes a user after confirming their credentials If no users exist, prompts
	 * the creation of a new user
	 */
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
	/**
	 * Displays transactions categorizing them into currency and crypto transactions
	 * If one is missing it will display the other one
	 */
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

	/**
	 * Checks users information of transactions, including both remitent and
	 * destinatary users
	 * 
	 * @return an array containing the remitent at 0 and the destinatary at 1
	 */
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
			System.out.println("Remitent not found! :(, TRY AGAIN");
			userTransactionChecker();
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
			System.out.println("Destinatary not found! :(, TRY AGAIN");
			userTransactionChecker();
		}
		return users;
	}

	/**
	 * Finds and returns the wallet associated with a specific coin for a given user
	 * 
	 * @param user the user whose wallets are checked
	 * @param coin the coin type to find in the user wallets
	 * @return the wallet containing the specified coin, or null if not found
	 */
	private Wallet findWallet(User user, Coin coin) {
		Wallet[] userWallets = user.getUserWallets();
		for (Wallet wallet : userWallets) {
			if (wallet.getCurrency() == coin) {
				return wallet;
			}
		}
		return null;
	}

	/**
	 * Displays a list of supported cryptocurrencies for transactions
	 */
	public void listOfCryptos() {
		System.out.println("For what crypto do you want to make the transaction?");
		System.out.println("BTC");
		System.out.println("ETH");
		System.out.println("XRP");
		System.out.println("ADA");
		System.out.println("SOL");
		System.out.println("LTC");
		System.out.println("XMR");
	}

	/**
	 * Creates a crypto transaction between 2 users Prompts user to specify
	 * transaction details Handles exceptions such as invalid coin selection and
	 * transaction errors
	 */
	public void cryptoTransaction() {
		try {
			User[] containerUsers = userTransactionChecker();
			listOfCryptos();
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
		} catch (IllegalArgumentException e) {
			System.err.println("NOT A CRYPTO COIN");
			cryptoTransaction();
		} catch (Exception e) {
			System.err.println("error..." + e.getMessage());
			cryptoTransaction();
		}
	}

	/**
	 * Displays a list of supported currencies for transactions
	 */
	public void listOfCurrency() {
		System.out.println("For what currency do you want to make the transaction?");
		System.out.println("USD");
		System.out.println("EUR");
		System.out.println("JPY");
		System.out.println("GBP");
		System.out.println("CHF");
		System.out.println("RUB");
		System.out.println("INR");
	}

	/**
	 * Facilitates a currency transaction between 2 users Prompts for user input to
	 * specify transaction details Handles exceptions such as invalid currency
	 * selection and transaction errors
	 */
	public void currencyTransaction() {
		try {
			User[] containerUsers = userTransactionChecker();
			listOfCurrency();
			Coin coin = Coin.valueOf(input.nextLine());
			System.out.println("Enter the amount for the transaction:");
			double amount = input.nextDouble();
			input.nextLine();
			if (containerUsers != null) {
				User remitent = containerUsers[0];
				User destinatary = containerUsers[1];

				Wallet remitentWallet = findWallet(remitent, coin);
				Wallet destinataryWallet = findWallet(destinatary, coin);
				TransactionCurrency currencyT = new TransactionCurrency(remitentWallet, destinataryWallet, amount);

				if (destinataryWallet != null && currencyT.sendTo(remitentWallet, destinataryWallet, amount)) {
					System.out.println("Transaction completed successfully!");
					currencyTransactions.add(currencyT);
				} else {
					System.out.println("Transaction failed.");
				}
			}
		} catch (IllegalArgumentException e) {
			System.err.println("NOT A NORMAL CURRENCY");
			cryptoTransaction();
		} catch (Exception e) {
			System.err.println("error..." + e.getMessage());
			cryptoTransaction();
		}

	}

	// wallet options
	/**
	 * Displays the wallets associated with a user after authentication Prompts for
	 * username and password Allows users to create a new account if no users exist
	 */
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
					System.out.println(user.getUsername());
					for (Wallet wallet : userWallets) {
						System.out.println(wallet);
					}
				} else {
					System.err.println("AUTH FAILED, try again..");
				}
			}
		}
	}
}
