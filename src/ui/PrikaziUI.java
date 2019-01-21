package ui;

import utils.PomocnaKlasa;

public class PrikaziUI {
	public static void meniUI() {
		int odluka = -1;
		while (odluka != 0) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				BuradUI.ispisSvihPiva();
				break;
			case 2:
				BuradUI.trenutnoStanje();
				break;
			case 3:
				OtpisUI.ispisSvihOtpisa();
				break;
			case 4:
				OtpisUI.ispisOtpisaNaDan();
				break;
			case 5:
				OtpisUI.ispisOtpisaNaPeriod();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}
	
	public static void ispisiMenu() {
		System.out.println();
		System.out.println("1. prikaz buradi");
		System.out.println("2.Trenutno na stanju");
		System.out.println("3.prikaz otpisa");
		System.out.println("4.otpisi na odredjen dan");
		System.out.println("5. otpisi za odredjen period");
		System.out.println("0 - IZLAZ");
	}
}
