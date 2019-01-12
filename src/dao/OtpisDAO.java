package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import evidencija.Burad;
import evidencija.Otpis;
import utils.PomocnaKlasa;

public class OtpisDAO {
	public static List<Otpis>getOtpis(Connection conn){
		 List<Otpis> otpis=new ArrayList<>();

			Statement stmt = null;
			ResultSet rset = null;
			try {String query="SELECT id,naziv,kolicina,datum FROM Otpis order by datum";
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				int id=rset.getInt(1);
				String naziv=rset.getString(2);
				double kolicina=rset.getDouble(3);
				Date datum=rset.getDate(4);
			
				Otpis n= new Otpis(id,naziv,kolicina,datum);
				otpis.add(n);
			}
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		 
		 return otpis;
	}
	
public static boolean addOtpis(Connection conn,String naziv,double kolicina) {
		
		Statement stmt = null;
		Date datum=PomocnaKlasa.tacanDatum();
		try {
			String s="INSERT INTO `pivaras`.`otpis` (`naziv`, `kolicina`, `datum`) VALUES ('"+naziv+"', '"+kolicina+"','"+datum+"');";
//			String query="INSERT INTO `pivaras`.`otpis` (`naziv`,`tezina`,`stiglo`) VALUES('" + bure.getNaziv()+ "',"+ bure.getTezina()+ ",'"+ bure.getStiglo()+"')";
//			String q="UPDATE `skara`.`burad` SET `istoceno`='" + istek + "',`prazno`='1' WHERE `id`='"+ id +"';";
			stmt=conn.createStatement();
			return stmt.executeUpdate(s)==1;
			
		}catch(SQLException ex) {
			System.out.println("Greska pri SQL upitu");
			ex.printStackTrace();
		}finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			
		}
		
		return false;
	}
	public static List<Otpis>getOtpisDan(Connection conn,Date datumO){
		 List<Otpis> otpis=new ArrayList<>();

			Statement stmt = null;
			ResultSet rset = null;
			try {String query="SELECT id,naziv,kolicina,datum FROM Otpis where datum = '"+ datumO+ "' order by datum";
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				int id=rset.getInt(1);
				String naziv=rset.getString(2);
				double kolicina=rset.getDouble(3);
				Date datum=rset.getDate(4);
			
				Otpis n= new Otpis(id,naziv,kolicina,datum);
				otpis.add(n);
			}
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		 
		 return otpis;
	}
	
	public static List<Otpis>getOtpisPeriod(Connection conn,Date datum1,Date datum2){
		 List<Otpis> otpis=new ArrayList<>();

			Statement stmt = null;
			ResultSet rset = null;
			try {String query="SELECT id,naziv,kolicina,datum FROM Otpis where (datum between '"+ datum1 + "' and '"+ datum2+ "') order by datum";
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				int id=rset.getInt(1);
				String naziv=rset.getString(2);
				double kolicina=rset.getDouble(3);
				Date datum=rset.getDate(4);
			
				Otpis n= new Otpis(id,naziv,kolicina,datum);
				otpis.add(n);
			}
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		 
		 return otpis;
	}
	
	
	public static double getOtpisDanSuma(Connection conn,Date datumO){
		
		double kolicina=0.0;
			Statement stmt = null;
			ResultSet rset = null;
			try {String query="SELECT sum(kolicina) FROM Otpis where datum = '"+ datumO+ "' order by datum";
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				
				 kolicina=rset.getDouble(1);
				
			
			}
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		 
		 return kolicina;
	}
	
	public static double getOtpisPeriodSuma(Connection conn,Date datum1,Date datum2){
		
		double kolicina=0.0;
			Statement stmt = null;
			ResultSet rset = null;
			try {
				String query="SELECT sum(kolicina) FROM Otpis where (datum between '"+ datum1 + "' and '"+ datum2+ "') order by datum";
				
				stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				
				 kolicina=rset.getDouble(1);
				
			
			}
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		 
		 return kolicina;
	}
}
