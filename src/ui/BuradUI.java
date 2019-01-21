package ui;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dao.BuradDAO;
import dao.OtpisDAO;
import evidencija.Burad;
import utils.PomocnaKlasa;

public class BuradUI {
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	public static void ispisSvihPiva() {
		List<Burad>svaBurad=BuradDAO.getBurad(ApplicationUI.getConn());
		System.out.println();
		System.out.println();
		System.out.printf("%-10s %-20s %-10s %-25s  %-25s %-25s %-15s  %-15s %-15s %-15s","id","naziv","tezina","stiglo","zakaceno","istoceno","broj dana","prazno(kg)","prazno","otpis(L)");
		System.out.println();
		System.out.println("===========================================================================================================================================================================================================");
		
		for (Burad burad: svaBurad) {
			Date kacenje=burad.getKacenje();
			Date istoceno=burad.getIstoceno();
			String kacenjeS=null;
			String istocenoS=null;
			String praznoS="";
			if(burad.isPrazno()==true) {
				praznoS="prazno";
			}else {
				praznoS="nije prazno";
			}
			if(kacenje!=null) {
				kacenjeS=PomocnaKlasa.DATUMP.format(burad.getKacenje());
			}else {
				kacenjeS="";
			}
			if(istoceno!=null) {
				istocenoS=PomocnaKlasa.DATUMP.format(burad.getIstoceno());
			}else {
				istocenoS="";
			}
			System.out.printf("%-10s %-20s %-10s %-25s  %-25s %-25s %-15s %-15s %-15s %-15s \n", 
					burad.getId(), 
					burad.getNaziv(),
					burad.getTezina(),
					PomocnaKlasa.DATUMP.format(burad.getStiglo()), 
					kacenjeS,
					istocenoS,
					burad.getDani(),
					burad.getTezinaPrazno(),
					praznoS,
					burad.getOtpis()
					); 
			System.out.println("===========================================================================================================================================================================================================");
		}
		System.out.println();
	}
	
	public static void trenutnoStanje() {
		List<Burad>svaBurad=BuradDAO.trenutnoStanje(ApplicationUI.getConn());
	
		System.out.printf("%-10s %-20s %-10s %-35s %-35s","id","naziv","tezina","stiglo","zakaceno");
		System.out.println();
		System.out.println("=================================================================================================================================");
		for (Burad burad: svaBurad) {
			String kacenjeS="";
			if(burad.getKacenje()!=null) {
				kacenjeS=PomocnaKlasa.DATUMP.format(burad.getKacenje());
			}
			String stigloS="";
			if(burad.getStiglo()!=null) {
				stigloS=PomocnaKlasa.DATUMP.format(burad.getStiglo());
			}
			System.out.printf("%-10s %-20s %-10s %-35s %-35s \n", 
					burad.getId(), 
					burad.getNaziv(),
					burad.getTezina(),
					stigloS, 
					kacenjeS
					); 
				
					

		}
	}
	public static void unesiteBure() {
		System.out.println("Unesi naziv:");
		String naziv=PomocnaKlasa.ocitajTekst();
		System.out.println(naziv);
		System.out.println("Unesi tezinu:");
		double tezina=PomocnaKlasa.ocitajRealanBrojDouble();
		System.out.println(tezina);
		System.out.println("Unesite datum prispeca:");
		Date datumP=PomocnaKlasa.ocitajDatumPravi();
		System.out.println(datumP);
		Burad bure=new Burad(naziv, tezina, datumP);
		BuradDAO.addPivo(ApplicationUI.getConn(),bure);
		System.out.println();
		System.out.println();
		
	}
	
	public static void unesiDatumKacenja() {
		System.out.println("Unesite redni broj bureta");
		int id=PomocnaKlasa.ocitajCeoBroj();
		System.out.println("Unesi datum kacenja");
		Date kacenje=PomocnaKlasa.ocitajDatumPravi();
		System.out.println(kacenje);
		Burad b=BuradDAO.getBure(ApplicationUI.getConn(), id);
		if(kacenje.compareTo(b.getStiglo())<0) {
			System.out.println();
			System.out.println("Datum kacenja je pre dana prispeca!!!!");
			System.out.println();
			return;
		}
		BuradDAO.uK(ApplicationUI.getConn(), kacenje, id);
		int dani=BuradDAO.getDane(ApplicationUI.getConn(), id);
		BuradDAO.addDane(ApplicationUI.getConn(), dani, id);
		System.out.println();
		System.out.println();
		
	}
	

	public static void unesiDatumIsteka() {
		System.out.println("Unesite redni broj bureta");
		int id=PomocnaKlasa.ocitajCeoBroj();
		System.out.println("Unesi datum raskacenja");
		Date raskacenje=PomocnaKlasa.ocitajDatumPravi();
		System.out.println(raskacenje);
		Burad b=BuradDAO.getBure(ApplicationUI.getConn(), id);
		if(raskacenje.compareTo(b.getKacenje())<0) {
			System.out.println();
			System.out.println("Datum raskacenja je pre dana kacenja!!");
			System.out.println();
			return;
		}
		
		System.out.println("Unesi tezinu praznog bureta");
		double praznoKG=PomocnaKlasa.ocitajRealanBrojDouble();
//		double kolicina=OtpisDAO.getOtpisPeriodSuma(ApplicationUI.getConn(), b.getKacenje(),raskacenje);
//		System.out.println(b.getKacenje() + " " + raskacenje);
		BuradDAO.uR(ApplicationUI.getConn(), raskacenje, id,praznoKG);
		int dani=BuradDAO.getDane(ApplicationUI.getConn(), id);
//		System.out.println(dani);
		BuradDAO.addDane(ApplicationUI.getConn(), dani, id);
		BuradDAO.prazno(ApplicationUI.getConn(), id);
	}
	
	
}
