package program;

/**
 * @author OffStef
 */
import resources.Banners;

import resources.Menus;

public class CryptoP2P {

	public static void main(String[] args) {
		Banners banner = new Banners();
		Menus menu = new Menus();

		// title of CryptoP2P
		banner.title();
		// menu that cointais all the program
		menu.initialMenu();
		// end banner
		banner.end();
	}

}
