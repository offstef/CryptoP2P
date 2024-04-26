package resources;

import java.util.Scanner;

import main.OperationManager;

public class Menus {
	Scanner input = new Scanner(System.in);
	OperationManager manager = new OperationManager();

	public void initialMenu() {
		int option = 0;
		do {
			try {
				System.out.println("CHOOSE AN OPTION");
				System.out.println("1. USER");
				System.out.println("2. TRANSACTION");
				System.out.println("3. WALLET");

				System.out.println();
				System.out.println("4. EXIT");
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
					throw new IllegalArgumentException("Not an option");
				}
			} catch (Exception e) {
				System.err.println("WROOOONG!!!");
				input.nextLine();
			}
		} while (option != 4);
	}

	public void userMenu() {
		int option;
		do {
			System.out.println("What you want to do?");
			System.out.println("	1. See all users");
			System.out.println("	2. Create an user");
			System.out.println("	3. Delete an user(requires auth)");
			System.out.println();
			System.out.println("	4.GO BACK ");
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
				throw new IllegalArgumentException("Not an option");
			}
		} while (option != 4);
	}

	public void transactionMenu() {
		int option;
		do {
			System.out.println("What you want to do?");
			System.out.println("	1. See all transactions");
			System.out.println("	2. Start a transaction");
			System.out.println();
			System.out.println("	3. GO BACK");
			option = input.nextInt();
			switch (option) {
			case 1:
				manager.seeTransactions();
				break;
			case 2:
				menuTransactions();
				break;
			case 3:
				break;
			default:
				throw new IllegalArgumentException("Not an option");
			}
		} while (option != 3);
	}

	public void walletMenu() {
		int option;
		do {
			System.out.println("What you want to do?");
			System.out.println("	1. See an user wallets(requires auth)");
			System.out.println();
			System.out.println("	2.GO BACK");
			option = input.nextInt();
			switch (option) {
			case 1:
				manager.walletUser();
				break;
			case 2:
				break;
			default:
				throw new IllegalArgumentException("Not an option");
			}
		} while (option != 2);
	}

	public void menuTransactions() {
		int option;
		do {
			System.out.println("What type of transaction do you want?");
			System.out.println("1. Crypto transaction");
			System.out.println("2. Currency transaction");
			System.out.println("3. GO BACK");
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
				throw new IllegalArgumentException("Not an option");
			}
		} while (option != 3);

	}

}
