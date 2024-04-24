package main;

import java.util.ArrayList;
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
		if(allUsers.isEmpty()) {
			System.out.println("No users created yet");
			System.out.println("Let's create one!!!");
			createUser();
		} else {
			for(User user : allUsers) {
				System.out.println(user);
			}
		}
	}
	
	public void deleteUser(User user) {
		
	}
	public void modifyUser(User user) {
		
	}
}
