package ui;

import utils.PomocnaKlasa;

public class UnosiUI {
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
				BuradUI.unesiteBure();
				break;
			case 2:
				BuradUI.unesiDatumKacenja();
				break;
			case 3:
				BuradUI.unesiDatumIsteka();
				break;
			case 4:
				OtpisUI.unesiNaOvajDan();
				break;
			
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}
	
	public static void ispisiMenu() {
		System.out.println();
		System.out.println("1.Unesi bure");
		System.out.println("2.unesi datum kacenja");
		System.out.println("3.unesi datum raskacenja");
		System.out.println("4.unesi otpis na ovaj dan");
		
		System.out.println("0 - IZLAZ");
		System.out.println();
	}
}
