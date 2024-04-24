package program;

import resources.Banners;

import resources.Menus;

public class CryptoP2P {

	public static void main(String[] args) {
		Banners banner = new Banners();
		Menus menu = new Menus();
		
		banner.title();
		menu.initialMenu();
		banner.end();
	}

}
