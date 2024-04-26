package resources;

import java.util.Scanner;

import main.OperationManager;

public class Menus {
	public static final String RESET = "\u001B[0m";
	Scanner input = new Scanner(System.in);
	OperationManager manager = new OperationManager();
	Banners banner = new Banners();

	/**
	 * First menu user will encounter options: -user -transaction -wallet
	 */
	public void initialMenu() {
		int option = 0;
		do {
			try {
				banner.separator();
				System.out.println();
				System.out.println("	\u001B[32mCHOOSE AN OPTION" + RESET);
				System.out.println();
				System.out.println("	1. USER");
				System.out.println("	2. TRANSACTION");
				System.out.println("	3. WALLET");
				System.out.println();
				System.out.println("	\u001B[31m4. EXIT" + RESET);
				System.out.println();
				banner.separator();
				option = input.nextInt();
				switch (option) {
				case 1:
					userMenu();
					break;
				case 2:
					transactionMenu();
					break;
				case 3:
					walletMenu();
					break;
				case 4:
					break;
				default:
					throw new Exception(" Not an option");
				}
			} catch (Exception e) {
				System.err.println("WROOOONG!!!");
				input.nextLine();
			}
		} while (option != 4);
	}

	/**
	 * menu for user options 
	 * options: 
	 * -see all users that have been created before
	 * hand, if there is no one lets the user create one 
	 * -create a new user 
	 * -delete a created user
	 */
	public void userMenu() throws Exception {
		int option;
		do {
			banner.separator();
			System.out.println();
			System.out.println("	\u001B[32mWHAT DO YOU WANT TO DO??" + RESET);
			System.out.println("	1. See all users");
			System.out.println("	2. Create an user");
			System.out.println("	3. Delete an user(requires auth)");
			System.out.println();
			System.out.println("	\u001B[31m4. GO BACK " + RESET);
			System.out.println();
			banner.separator();
			option = input.nextInt();
			switch (option) {
			case 1:
				manager.seeUsers();
				break;
			case 2:
				manager.createUser();
				break;
			case 3:
				manager.deleteUser();
				break;
			case 4:
				break;
			default:
				throw new Exception("Not an option");
			}
		} while (option != 4);
	}

	/**
	 * menu for transaction managing 
	 * options: 
	 * -see all transaction that have been
	 * made before hand 
	 * -delete an transaction
	 */
	public void transactionMenu() throws Exception {
		int option;
		do {
			banner.separator();
			System.out.println();
			System.out.println("	\u001B[32mWHAT DO YOU WANT TO DO??" + RESET);
			System.out.println("	1. See all transactions");
			System.out.println("	2. Start a transaction");
			System.out.println();
			System.out.println("	\u001B[31m3. GO BACK " + RESET);
			System.out.println();
			banner.separator();
			option = input.nextInt();
			switch (option) {
			case 1:
				manager.seeTransactions();
				break;
			case 2:
				typeOfTransactionMenu();
				break;
			case 3:
				break;
			default:
				throw new Exception("Not an option");
			}
		} while (option != 3);
	}

	/**
	 * menu for wallet options 
	 * options: 
	 * -see an user wallets in general
	 */
	public void walletMenu() throws Exception {
		int option;
		do {
			banner.separator();
			System.out.println();
			System.out.println("	\u001B[32mWHAT DO YOU WANT TO DO??" + RESET);
			System.out.println("	1. See an user wallets(requires auth)");
			System.out.println();
			System.out.println("	\u001B[31m2. GO BACK " + RESET);
			System.out.println();
			banner.separator();
			option = input.nextInt();
			switch (option) {
			case 1:
				manager.walletUser();
				break;
			case 2:
				break;
			default:
				throw new Exception("Not an option");
			}
		} while (option != 2);
	}

	/**
	 * menu for managing inside the other transactions menu about the type of
	 * transaction that wants to be made 
	 * options: 
	 * -crypto transaction -currency
	 * transaction
	 */
	public void typeOfTransactionMenu() throws Exception {
		int option;
		do {
			banner.separator();
			System.out.println();
			System.out.println("	\u001B[32mWHAT TYPE OF TRANSACTION??" + RESET);
			System.out.println("	1. Crypto transaction");
			System.out.println("	2. Currency transaction");
			System.out.println();
			System.out.println("	\u001B[31m3. GO BACK " + RESET);
			System.out.println();
			banner.separator();
			option = input.nextInt();
			switch (option) {
			case 1:
				manager.cryptoTransaction();
				break;
			case 2:
				manager.currencyTransaction();
				break;
			case 3:
				break;
			default:
				throw new Exception("Not an option");
			}
		} while (option != 3);

	}

}
