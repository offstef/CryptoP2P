package resources;

import java.util.Scanner;

import main.OperationManager;

public class Menus {
	Scanner input = new Scanner(System.in);
	OperationManager manager = new OperationManager();

	public void initialMenu() {
		int option;
		do {
			System.out.println("What you want to do?");
			System.out.println("-USER");
			System.out.println("	1. See all users");
			System.out.println("	2. Create an user");
			System.out.println("	3. Delete an user");
			System.out.println("-TRANSACTION");
			System.out.println("	4. See all transactions");
			System.out.println("	5. Create an transaction");
			System.out.println("-WALLET");
			System.out.println("	6. See an user wallets");
			System.out.println("	7. Check wealth of an user");
			
			System.out.println();
			System.out.println("			8.EXIT");
			option = input.nextInt();
			switch (option) {
			case 1:
				manager.seeUsers();
				break;
			case 2:
				manager.createUser();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				
				break;
			case 7:
				break;
			default:
				break;
			}
		} while (option != 8);
	}

}
