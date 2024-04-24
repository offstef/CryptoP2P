package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class OperationManager {
	private ArrayList<User> allUsers = new ArrayList<>();
	static Scanner input = new Scanner(System.in);

	public void createUser() {
		User user = new User();
		System.out.print("What's your name: ");
		user.setUsername(input.nextLine());
		System.out.println("Set your password");
		user.setPassword(input.nextLine());
		allUsers.add(user);
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
}
