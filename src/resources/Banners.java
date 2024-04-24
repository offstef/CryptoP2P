package resources;

public class Banners {
	public static final String COLOR_RESET = "\u001B[0m";
	public void title () {
		System.out.println("\u001B[34m  @@@@@@@ @@@@@@@  @@@ @@@ @@@@@@@  @@@@@@@  @@@@@@    @@@@@@@   @@@@@@  @@@@@@@ ");
        System.out.println("\u001B[33m !@@      @@!  @@@ @@! !@@ @@!  @@@   @@!   @@!  @@@   @@!  @@@ @@   @@@ @@!  @@@");
        System.out.println("\u001B[33m !@!      @!@!!@!   !@!@!  @!@@!@!    @!!   @!@  !@!   @!@@!@!    .!!@!  @!@@!@! ");
        System.out.println("\u001B[31m :!!      !!: :!!    !!:   !!:        !!:   !!:  !!!   !!:       !!:     !!:     ");
        System.out.println("\u001B[31m  :: :: :  :   : :   .:     :          :     : :. :    :       :.:: :::  :      "+ COLOR_RESET);
        System.out.println();
	}
	
	public void end() {
		System.err.println("\u001B[34m _____ _____ ____    ");
        System.err.println("\u001B[34m|   __|   | |    \\   ");
        System.err.println("\u001B[33m|   __| | | |  |  |_ ");
        System.err.println("\u001B[31m|_____|_|___|____/|_|"+ COLOR_RESET);
	}
	
}
