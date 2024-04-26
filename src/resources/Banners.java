package resources;

public class Banners {
	public static final String RESET = "\u001B[0m";
	public void title () {
		System.out.println("\u001B[36m  @@@@@@@ @@@@@@@  @@@ @@@ @@@@@@@  @@@@@@@  @@@@@@    @@@@@@@   @@@@@@  @@@@@@@ ");
        System.out.println("\u001B[33m !@@      @@!  @@@ @@! !@@ @@!  @@@   @@!   @@!  @@@   @@!  @@@ @@   @@@ @@!  @@@");
        System.out.println("\u001B[33m !@!      @!@!!@!   !@!@!  @!@@!@!    @!!   @!@  !@!   @!@@!@!    .!!@!  @!@@!@! ");
        System.out.println("\u001B[31m :!!      !!: :!!    !!:   !!:        !!:   !!:  !!!   !!:       !!:     !!:     ");
        System.out.println("\u001B[31m  :: :: :  :   : :   .:     :          :     : :. :    :       :.:: :::  :      "+ RESET);
        System.out.println();
	}
	
	public void end() {
		System.err.println("\u001B[36m _____ _____ ____    ");
        System.err.println("\u001B[36m|   __|   | |    \\   ");
        System.err.println("\u001B[33m|   __| | | |  |  |_ ");
        System.err.println("\u001B[31m|_____|_|___|____/|_|"+ RESET);
	}
	public void separator() {
		System.out.println("\u001B[36m###---###---###---###---###---###---###---###" + RESET);
	}
}
