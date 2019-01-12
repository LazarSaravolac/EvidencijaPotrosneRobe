package evidencija;

import java.sql.Date;

public class Otpis {

	private int id;
	private String naziv;
	private double kolicina;
	private Date datumOtpisa;
	public Otpis(int id, String naziv, double kolicina, Date datumOtpisa) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.datumOtpisa = datumOtpisa;
	}
	public Otpis() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public Date getDatumOtpisa() {
		return datumOtpisa;
	}
	public void setDatumOtpisa(Date datumOtpisa) {
		this.datumOtpisa = datumOtpisa;
	}
	
}
