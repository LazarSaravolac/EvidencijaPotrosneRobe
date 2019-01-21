package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import evidencija.Burad;

public class BuradDAO {
	
public static Burad getBureNazivKolicina(Connection conn,int id) {
		String naziv=null;
		double kolicina=0;
		Burad bure=new Burad();
		Statement stmt = null;
		ResultSet rset = null;
		try {String query="SELECT naziv,otpis FROM Burad where id=" + id;
		stmt=conn.createStatement();
		rset=stmt.executeQuery(query);
		while(rset.next()) {
			naziv=rset.getString(1);
			kolicina=rset.getDouble(2);
			bure.setNaziv(naziv);
			bure.setOtpis(kolicina);
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
		
		return bure;
	}
	
	
	
	public static Burad getBure(Connection conn,int id) {
		
		Burad bure=new Burad();
		Statement stmt = null;
		ResultSet rset = null;
		try {String query="SELECT stiglo,zakaceno,istoceno FROM Burad where id=" + id;
		stmt=conn.createStatement();
		rset=stmt.executeQuery(query);
		while(rset.next()) {
			Date stiglo=rset.getDate(1);
			Date zakaceno=rset.getDate(2);
			Date istoceno=rset.getDate(3);
			bure.setStiglo(stiglo);
			bure.setKacenje(zakaceno);
			bure.setIstoceno(istoceno);
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
		
		return bure;
	}
	
	
	
	
	public static List<Burad>getBurad(Connection conn){
		 List<Burad> burad=new ArrayList<>();

			Statement stmt = null;
			ResultSet rset = null;
			try {String query="SELECT id,naziv,tezina,stiglo,zakaceno,istoceno,dani,tezinaP,prazno,otpis FROM Burad";
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				int id=rset.getInt(1);
				String naziv=rset.getString(2);
				double tezina=rset.getDouble(3);
				Date stiglo=rset.getDate(4);
				Date zakaceno=rset.getDate(5);
				Date istoceno=rset.getDate(6);
				int dani=rset.getInt(7);
				double tezP=rset.getDouble(8);
				boolean prazno=rset.getBoolean(9);
				double otpis=rset.getDouble(10);
				Burad n= new Burad(id,naziv,tezina,stiglo,zakaceno,istoceno,dani,tezP,prazno,otpis);
				burad.add(n);
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
		 
		 
		 return burad;
	}
	
	public static List<Burad>trenutnoStanje(Connection conn){
		 List<Burad> burad=new ArrayList<>();

			Statement stmt = null;
			ResultSet rset = null;
			try {String query="SELECT id,naziv,tezina,stiglo,zakaceno FROM Burad WHERE prazno is null or prazno=0";
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				int id=rset.getInt(1);
				String naziv=rset.getString(2);
				double tezina=rset.getDouble(3);
				Date stiglo=rset.getDate(4);
				Date zakaceno=rset.getDate(5);
				
				Burad n= new Burad(id,naziv,tezina,stiglo,zakaceno);
				burad.add(n);
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
		 
		 
		 return burad;
	}

	public static int getDane(Connection conn,int id){
		 
		int ids=0;
			Statement stmt = null;
			ResultSet rset = null;
			try {String query="SELECT datediff(istoceno,zakaceno) FROM Burad where id=" + id;
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			while(rset.next()) {
				ids=rset.getInt(1);
				
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
		 
		 
		 return ids;
	}
	
	

public static boolean addPivo(Connection conn,Burad bure) {
		
		Statement stmt = null;
		
		try {
			String query="INSERT INTO `pivaras`.`burad` (`naziv`,`tezina`,`stiglo`) VALUES('" + bure.getNaziv()+ "',"+ bure.getTezina()+ ",'"+ bure.getStiglo()+"')";
//			String q="UPDATE `skara`.`burad` SET `istoceno`='" + istek + "',`prazno`='1' WHERE `id`='"+ id +"';";
			stmt=conn.createStatement();
			return stmt.executeUpdate(query)==1;
			
		}catch(SQLException ex) {
			System.out.println("Greska pri SQL upitu");
			ex.printStackTrace();
		}finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			
		}
		
		return false;
	}


public static boolean addDane(Connection conn,int dani,int id) {
		
		Statement stmt = null;
		
		try {
			dani=dani+1;
			String query="INSERT INTO `pivaras`.`burad` (`dani`) VALUES('" +dani+ "')";
			String q="UPDATE `pivaras`.`burad` SET `dani`='" + dani + "' WHERE `id`='"+ id +"';";
//			String q="UPDATE `skara`.`burad` SET `istoceno`='" + istek + "',`prazno`='1' WHERE `id`='"+ id +"';";
			stmt=conn.createStatement();
			return stmt.executeUpdate(q)==1;
			
		}catch(SQLException ex) {
			System.out.println("Greska pri SQL upitu");
			ex.printStackTrace();
		}finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			
		}
		
		return false;
	}
	
public static boolean unosKacenja(Connection conn,Date datum,int id) {
	PreparedStatement pstmt = null;
	try {
//		String q="UPDATE `skara`.`burad` SET `istoceno`='2013-11-01 12:01:100' WHERE `id`='1';";
		String query="UPDATE Burad SET istoceno = ? WHERE id = ?";
		pstmt=conn.prepareStatement(query);
		pstmt.setDate(1, datum);
		pstmt.setInt(2, id);
		return pstmt.executeUpdate(query)==1;
	}catch(SQLException ex) {
		System.out.println("Greska pri SQL upitu");
		ex.printStackTrace();
	}finally {
		try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
	}
	return false;
}


public static boolean updateOtpis(Connection conn,double kolicina,int id) {
	
	Statement stmt = null;
	
	try {
//		String query="INSERT INTO `piva`.`burad` (`naziv`,`tezina`,`stiglo`) VALUES('" + bure.getNaziv()+ "',"+ bure.getTezina()+ ",'"+ bure.getStiglo()+"')";
//		String q="UPDATE `skara`.`burad` SET `istoceno`='" + istek + "',`prazno`='1' WHERE `id`='"+ id +"';";
		String q="UPDATE `pivaras`.`burad` SET `otpis`='"+kolicina+"' WHERE `id`='"+ id+"';";
		stmt=conn.createStatement();
		return stmt.executeUpdate(q)==1;
		
	}catch(SQLException ex) {
		System.out.println("Greska pri SQL upitu");
		ex.printStackTrace();
	}finally {
		try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		
	}
	
	return false;
}

public static boolean uK(Connection conn,Date datum,int id) {
	
	Statement stmt = null;
	
	try {
//		String query="INSERT INTO `piva`.`burad` (`naziv`,`tezina`,`stiglo`) VALUES('" + bure.getNaziv()+ "',"+ bure.getTezina()+ ",'"+ bure.getStiglo()+"')";
//		String q="UPDATE `skara`.`burad` SET `istoceno`='" + istek + "',`prazno`='1' WHERE `id`='"+ id +"';";
		String q="UPDATE `pivaras`.`burad` SET `zakaceno`='"+datum+"' WHERE `id`='"+ id+"';";
		stmt=conn.createStatement();
		return stmt.executeUpdate(q)==1;
		
	}catch(SQLException ex) {
		System.out.println("Greska pri SQL upitu");
		ex.printStackTrace();
	}finally {
		try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		
	}
	
	return false;
}

public static boolean uR(Connection conn,Date datum,int id,double kg) {
	
	Statement stmt = null;
	
	try {
//		String query="INSERT INTO `piva`.`burad` (`naziv`,`tezina`,`stiglo`) VALUES('" + bure.getNaziv()+ "',"+ bure.getTezina()+ ",'"+ bure.getStiglo()+"')";
//		String q="UPDATE `skara`.`burad` SET `istoceno`='" + istek + "',`prazno`='1' WHERE `id`='"+ id +"';";
		String q="UPDATE `pivaras`.`burad` SET `istoceno`='"+datum+"',tezinaP='"+kg+"' WHERE `id`='"+ id+"';";
		stmt=conn.createStatement();
		return stmt.executeUpdate(q)==1;
		
	}catch(SQLException ex) {
		System.out.println("Greska pri SQL upitu");
		ex.printStackTrace();
	}finally {
		try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		
	}
	
	return false;
}



public static boolean prazno(Connection conn,int id) {
	
	Statement stmt = null;
	
	try {
//		String query="INSERT INTO `piva`.`burad` (`naziv`,`tezina`,`stiglo`) VALUES('" + bure.getNaziv()+ "',"+ bure.getTezina()+ ",'"+ bure.getStiglo()+"')";
//		String q="UPDATE `skara`.`burad` SET `istoceno`='" + istek + "',`prazno`='1' WHERE `id`='"+ id +"';";
		String q="UPDATE `pivaras`.`burad` SET `prazno`='1' WHERE `id`='"+ id+"';";
		stmt=conn.createStatement();
		return stmt.executeUpdate(q)==1;
		
	}catch(SQLException ex) {
		System.out.println("Greska pri SQL upitu");
		ex.printStackTrace();
	}finally {
		try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		
	}
	
	return false;
}

}
