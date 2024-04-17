package resources;

import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	
	public void initialMenu() {
		int option;
		do {
			option = input.nextInt();
		}
		while (option !=6) ;
	}

}
