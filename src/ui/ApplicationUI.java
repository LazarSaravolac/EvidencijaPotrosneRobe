package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;

import utils.PomocnaKlasa;

public class ApplicationUI {

	private static Connection conn;
	
	public static Connection getConn() {
		return conn;
	}





	static {
		try {
			// ucitavanje MySQL drajvera
						Class.forName("com.mysql.jdbc.Driver");
						// otvaranje konekcije
						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/pivaras?useSSL=false", 
								"root", 
								"root");
		} catch (Exception ex) {
			System.out.println("Neuspela konekcija na bazu!");
			ex.printStackTrace();

			// kraj aplikacije
			System.exit(0);
		}
	}
	
	public static void meni() {
		
//		System.out.println("1. prikaz buradi");
		System.out.println("1.Prikazi");
		System.out.println("2.Unosi");
		
		System.out.println("0. Izlaz");
//		System.out.println("2.Unesi bure");
//		System.out.println("3.unesi datum kacenja");
//		System.out.println("4.unesi datum raskacenja");
//		System.out.println("5.Trenutno na stanju");
//		System.out.println("6.prikaz otpisa");
//		System.out.println("7.otpisi na odredjen dan");
//		System.out.println("7.Unesite Otpis");
//		System.out.println("8. otpisi za odredjen period");
//		System.out.println("9.unesi otpis na ovaj dan");
//		System.out.println("3. dodavanje poziva");
//		System.out.println("4. statistika");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int odluka=-1;
	while(odluka!=0) {
		meni();
		System.out.println("Unesi opciju");
		odluka=PomocnaKlasa.ocitajCeoBroj();
		switch(odluka) {
		case 0:
			System.out.println("Izlaz iz programa");
			break;
		case 1:
//			BuradUI.ispisSvihPiva();
			PrikaziUI.meniUI();
			break;
		case 2:
			UnosiUI.meniUI();
			break;
		case 3:
//			BuradUI.unesiDatumKacenja();
			break;
		case 4:
//			BuradUI.unesiDatumIsteka();
			break;
		case 5:
//			BuradUI.trenutnoStanje();
			break;
		case 6:
//			OtpisUI.ispisSvihOtpisa();
			break;
		case 7:
//			OtpisUI.ispisOtpisaNaDan();
			break;
		case 8:
//			OtpisUI.ispisOtpisaNaPeriod();
			break;
		case 9:
//			OtpisUI.unesiNaOvajDan();
			break;
		}
	}
	}

}
