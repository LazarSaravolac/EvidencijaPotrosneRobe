package evidencija;

import java.sql.Date;

public class Burad {
	private int id;
	private String naziv;
	private double tezina;
	private Date stiglo;
	private Date kacenje;
	private Date istoceno;
	private int dani;
	private boolean prazno;
	private double tezinaPrazno;
	private double otpis;
	public Burad(int id, String naziv, double tezina, Date stiglo, Date kacenje, Date istoceno, int dani,double tezinaPrazno,
			boolean prazno, double otpis) {
		super();
		this.tezinaPrazno=tezinaPrazno;
		this.id = id;
		this.naziv = naziv;
		this.tezina = tezina;
		this.stiglo = stiglo;
		this.kacenje = kacenje;
		this.istoceno = istoceno;
		this.dani = dani;
		this.prazno = prazno;
		this.otpis = otpis;
	}
	
	public Burad(int id, String naziv, double tezina, Date stiglo, Date kacenje, Date istoceno, int dani,
			boolean prazno, double otpis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tezina = tezina;
		this.stiglo = stiglo;
		this.kacenje = kacenje;
		this.istoceno = istoceno;
		this.dani = dani;
		this.prazno = prazno;
		this.otpis = otpis;
	}

	public Burad() {
		super();
	}
	public Burad(String naziv, double tezina, Date stiglo) {
		super();
		
		this.naziv = naziv;
		this.tezina = tezina;
		this.stiglo = stiglo;
	}
	public Burad(int id, String naziv, double tezina, Date stiglo, Date kacenje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tezina = tezina;
		this.stiglo = stiglo;
		this.kacenje = kacenje;
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
	public double getTezina() {
		return tezina;
	}
	public void setTezina(double tezina) {
		this.tezina = tezina;
	}
	public Date getStiglo() {
		return stiglo;
	}
	public void setStiglo(Date stiglo) {
		this.stiglo = stiglo;
	}
	public Date getKacenje() {
		return kacenje;
	}
	public void setKacenje(Date kacenje) {
		this.kacenje = kacenje;
	}
	public Date getIstoceno() {
		return istoceno;
	}
	public void setIstoceno(Date istoceno) {
		this.istoceno = istoceno;
	}
	public int getDani() {
		return dani;
	}
	public void setDani(int dani) {
		this.dani = dani;
	}
	public boolean isPrazno() {
		return prazno;
	}
	public void setPrazno(boolean prazno) {
		this.prazno = prazno;
	}
	public double getOtpis() {
		return otpis;
	}
	public void setOtpis(double otpis) {
		this.otpis = otpis;
	}
	public double getTezinaPrazno() {
		return tezinaPrazno;
	}
	public void setTezinaPrazno(double tezinaPrazno) {
		this.tezinaPrazno = tezinaPrazno;
	}
	
	
}
