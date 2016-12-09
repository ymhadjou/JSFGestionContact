package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Adresse;

public class AdresseDAO {
	
	public AdresseDAO()
	{

			
	}
	
	
	public void createAddressDAO(String street, String city, String cp, String country)
	{
		//Configuration
		String driver ="com.mysql.jdbc.Driver";
		//String url ="jdbc:mysql://localhost:3306/GestionContact?useSSL=false";
		//String user ="root";
		//String password ="root";
		String url = "jdbc:mysql://127.0.0.1:3306/gestioncontact?useSSL=false";
		String user ="root";
		String password ="root";
		String requete="";
		Connection cx = null;
		Statement stmt = null;
		
		try
		{
			//Configuration
			Class.forName(driver);
			cx = DriverManager.getConnection(url, user, password);
			
			//Statement
			 stmt = cx.createStatement();
			 requete = "INSERT INTO adresse(rue,ville,cp,pays) VALUES " + "('" + street +"','" + city + "','" + cp + "','" + country + "')";
			 System.out.println(requete);
			 int nb = stmt.executeUpdate(requete);
			 System.out.println("Nombre de lignes mises à jour = " + nb);

		}
		catch(ClassNotFoundException e)
		{
			e.toString();
		}
		catch(SQLException e)
		{
			e.toString();
		}
		finally
		{
			try
			{
				if(cx!=null)
				{
					cx.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		} 
	}
	
	
	public void modifyAddressDAO(Adresse a)
	{
		//Configuration
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/GestionContact?useSSL=false";
		String user ="root";
		String password ="root";
		String requete="";
		Connection cx = null;
		Statement stmt = null;
		try
		{
			//Configuration
			Class.forName(driver);
			cx = DriverManager.getConnection(url, user, password);
			
			//Statement
			 stmt = cx.createStatement();
			 requete = "UPDATE adresse SET rue = '" + a.getStreet() + "', ville = '" + a.getCity() + "', cp = '" + a.getZip() + "', pays = '" + a.getCountry() + "' WHERE id =" + a.getId() +"";
			 System.out.println(requete);
			 int nb = stmt.executeUpdate(requete);
			 System.out.println("Nombre de lignes affectées = " + nb);
			 
		}
		catch(ClassNotFoundException e)
		{
			e.toString();
		}
		catch(SQLException e)
		{
			e.toString();
		}
		finally
		{
			try
			{
				if(cx!=null)
				{
					cx.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteAddressDAO(Adresse a)
	{
		//Configuration
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/GestionContact?useSSL=false";
		String user ="root";
		String password ="root";
		String requete="";
		Connection cx = null;
		Statement stmt = null;
			try
			{
				//Configuration
				Class.forName(driver);
				cx = DriverManager.getConnection(url, user, password);
				
				//Statement
				 stmt = cx.createStatement();
				 requete = "DELETE FROM Adresse WHERE id = '" + a.getId() + "'";
				 int nb = stmt.executeUpdate(requete);
				 System.out.println(requete);
				 System.out.println("Nombre de lignes supprimées = " + nb);
			}
			catch(ClassNotFoundException e)
			{
				e.toString();
			}
			catch(SQLException e)
			{
				e.toString();
			}
			finally
			{
				try
				{
					if(cx!=null)
					{
						cx.close();
					}
					if(stmt!=null)
					{
						stmt.close();
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	
	public void FetchAddressDAO(String id)
	{
		//Configuration
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/GestionContact";
		String user ="root";
		String password ="root";
		String requete="";
		Connection cx = null;
		Statement stmt = null;
		try
		{
			//Configuration
			Class.forName(driver);
			cx = DriverManager.getConnection(url, user, password);
			
			//Statement
			 stmt = cx.createStatement();
			 requete = "SELECT * FROM adresse WHERE fk_idContact_adresse = '" + id  + "'";
			 ResultSet rs = stmt.executeQuery(requete);
			 while(rs.next())
			 {
				 System.out.println("Rue : " + rs.getString("rue") +" \nVille: " + rs.getString("ville") + "\nCP : " + rs.getString("cp") + "\nPays : " +rs.getString("pays"));
			 }
		}
		catch(ClassNotFoundException e)
		{
			e.toString();
		}
		catch(SQLException e)
		{
			e.toString();
		}
		finally
		{
			try
			{
				if(cx!=null)
				{
					cx.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Adresse> listAddresses(){
		ArrayList<Adresse> addresses = new ArrayList<Adresse>();
		Adresse uneAdresse;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/gestioncontact?useSSL=false";
		String uid = "root"; String passwd = "root";
		String requete;
		Connection cx = null;
		Statement stmt = null;
		
		try
		{
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.createStatement();
			requete = "select * from adresse";
			ResultSet rs = stmt.executeQuery(requete);
			
				while(rs.next())
				{
					uneAdresse = new Adresse(rs.getInt("id"),rs.getString("ville"),rs.getString("cp"),rs.getString("pays"),rs.getString("rue"));
					addresses.add(uneAdresse);
				}
			} catch (ClassNotFoundException e) {
				
				// classe du pilote introuvable
				
			} catch (SQLException e) {
				
				System.out.println(e.toString());
				
			} finally {
			try { 
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();}
			catch (SQLException e) { e.printStackTrace(); }
			}
		
		
		return addresses;
	}
}
