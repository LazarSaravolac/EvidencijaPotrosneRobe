package ui;

import java.sql.Date;
import java.util.List;

import dao.BuradDAO;
import dao.OtpisDAO;
import evidencija.Burad;
import evidencija.Otpis;
import utils.PomocnaKlasa;

public class OtpisUI {

	public static void ispisSvihOtpisa() {
		List<Otpis>savOtpis=OtpisDAO.getOtpis(ApplicationUI.getConn());
		System.out.printf("%-10s %-20s %-10s %-35s","id","naziv","kolicina","datum");
		System.out.println();
		System.out.println("=======================================================================================================================================");
		for (Otpis otpis: savOtpis) {
			String datumS="";
			if(otpis.getDatumOtpisa()!=null) {
				datumS=PomocnaKlasa.DATUMP.format(otpis.getDatumOtpisa());
			}
			System.out.printf("%-10s %-20s %-10s %-35s \n", 
					otpis.getId(), 
					otpis.getNaziv(),
					otpis.getKolicina(),
					datumS
					); 
		System.out.println("=======================================================================================================================================");
			
	}
		
		
}
	
	public static void unesiNaOvajDan() {
		System.out.println("Unesi id bureta za otpis piva");
		int id= PomocnaKlasa.ocitajCeoBroj();
		System.out.println("Unesi kolicinu");
		double kolicina=PomocnaKlasa.ocitajRealanBrojDouble();
		Burad bure=BuradDAO.getBureNazivKolicina(ApplicationUI.getConn(), id);
		System.out.println(bure.getOtpis() +  "  " + bure.getNaziv());
		bure.setOtpis(bure.getOtpis()+kolicina);
		System.out.println(bure.getOtpis());
		OtpisDAO.addOtpis(ApplicationUI.getConn(), bure.getNaziv(),kolicina);
		BuradDAO.updateOtpis(ApplicationUI.getConn(), bure.getOtpis(), id);
	}
	
	public static void ispisOtpisaNaDan() {
		System.out.println("Unesite zeljeni datum");
		Date datum=PomocnaKlasa.ocitajDatumPravi();
		
		double kolicina=OtpisDAO.getOtpisDanSuma(ApplicationUI.getConn(), datum);
		System.out.println();
		System.out.println();
		System.out.println("Ukupna suma otpisa:");
		System.out.println(kolicina);
		System.out.println();
		List<Otpis>savOtpis=OtpisDAO.getOtpisDan(ApplicationUI.getConn(), datum);
		System.out.printf("%-10s %-20s %-10s %-35s","id","naziv","kolicina","datum");
		System.out.println();
		System.out.println("=======================================================================================================================================");
		for (Otpis otpis: savOtpis) {
			String datumS="";
			if(otpis.getDatumOtpisa()!=null) {
				datumS=PomocnaKlasa.DATUMP.format(otpis.getDatumOtpisa());
			}
			System.out.printf("%-10s %-20s %-10s %-35s \n", 
					otpis.getId(), 
					otpis.getNaziv(),
					otpis.getKolicina(),
					datumS
					); 
		System.out.println("=======================================================================================================================================");
			
	}
		
		
		
	}
	
	public static void ispisOtpisaNaPeriod() {
		System.out.println("Unesite pocetak perioda");
		Date datum1=PomocnaKlasa.ocitajDatumPravi();
		System.out.println("Unesite kraj perioda");
		Date datum2=PomocnaKlasa.ocitajDatumPravi();
		double kolicina=OtpisDAO.getOtpisPeriodSuma(ApplicationUI.getConn(), datum1,datum2);
		System.out.println();
		System.out.println();
		System.out.println("Ukupna suma otpisa:");
		System.out.println(kolicina);
		System.out.println();
		List<Otpis>savOtpis=OtpisDAO.getOtpisPeriod(ApplicationUI.getConn(), datum1,datum2);
		System.out.printf("%-10s %-20s %-10s %-35s","id","naziv","kolicina","datum");
		System.out.println();
		System.out.println("=======================================================================================================================================");
		for (Otpis otpis: savOtpis) {
			String datumS="";
			if(otpis.getDatumOtpisa()!=null) {
				datumS=PomocnaKlasa.DATUMP.format(otpis.getDatumOtpisa());
			}
			System.out.printf("%-10s %-20s %-10s %-35s \n", 
					otpis.getId(), 
					otpis.getNaziv(),
					otpis.getKolicina(),
					datumS
					); 
		System.out.println("=======================================================================================================================================");
			
	}
		
		
		
	}
}
