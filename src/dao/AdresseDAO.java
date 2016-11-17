package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdresseDAO {
	
	public AdresseDAO()
	{

			
	}
	
	
	public void CreateAddressDAO(String street, String city, String cp, String country, String idContact)
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
			 requete = "INSERT INTO adresse(rue,ville,cp,pays, fk_idContact_adresse) VALUES " + "('" + street +"','" + city + "','" + cp + "','" + country + "','" +idContact+"')";
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
	
	
	public void ModifyAddressDAO(String street, String city, String cp, String country, String idContact)
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
			 requete = "UPDATE adresse SET rue = '" + street + "', ville = '" + city + "', cp = '" + cp + "', pays = '" + country + "' WHERE fk_idContact_adresse = '" + idContact + "'";
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
	
	public void DeleteAddressDAO(String id)
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
				 requete = "DELETE FROM Adresse WHERE id = '" + id + "'";
				 int nb = stmt.executeUpdate(requete);
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
}
