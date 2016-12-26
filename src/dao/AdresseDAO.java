package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Adresse;

public class AdresseDAO {
	public Connection connect = ConnectionDatabase.getInstance();
	
	public AdresseDAO()
	{

			
	}
	
	
	public void createAddressDAO(String street, String city, String cp, String country)
	{

		String requete="";
		Statement stmt = null;
		
		try
		{

			//Statement
			 stmt = connect.createStatement();
			 requete = "INSERT INTO adresse(rue,ville,cp,pays) VALUES " + "('" + street +"','" + city + "','" + cp + "','" + country + "')";
			 System.out.println(requete);
			 int nb = stmt.executeUpdate(requete);
			 System.out.println("Nombre de lignes mises à jour = " + nb);

		}
		catch(SQLException e)
		{
			e.toString();
		}
		finally
		{
			try
			{
				if(connect!=null)
				{
					connect.close();
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

		String requete="";
		Statement stmt = null;
		try
		{
			//Statement
			 stmt = connect.createStatement();
			 requete = "UPDATE adresse SET rue = '" + a.getStreet() + "', ville = '" + a.getCity() + "', cp = '" + a.getZip() + "', pays = '" + a.getCountry() + "' WHERE id =" + a.getId() +"";
			 System.out.println(requete);
			 int nb = stmt.executeUpdate(requete);
			 System.out.println("Nombre de lignes affectées = " + nb);
			 
		}
		catch(SQLException e)
		{
			e.toString();
		}
		finally
		{
			try
			{
				if(connect!=null)
				{
					connect.close();
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

		String requete="";
		Statement stmt = null;
			try
			{
				//Statement
				 stmt = connect.createStatement();
				 requete = "DELETE FROM Adresse WHERE id = '" + a.getId() + "'";
				 int nb = stmt.executeUpdate(requete);
				 System.out.println(requete);
				 System.out.println("Nombre de lignes supprimées = " + nb);
			}
			catch(SQLException e)
			{
				e.toString();
			}
			finally
			{
				try
				{
					if(connect!=null)
					{
						connect.close();
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
		String requete="";
		Statement stmt = null;
		try
		{
			//Statement
			 stmt = connect.createStatement();
			 requete = "SELECT * FROM adresse WHERE fk_idContact_adresse = '" + id  + "'";
			 ResultSet rs = stmt.executeQuery(requete);
			 while(rs.next())
			 {
				 System.out.println("Rue : " + rs.getString("rue") +" \nVille: " + rs.getString("ville") + "\nCP : " + rs.getString("cp") + "\nPays : " +rs.getString("pays"));
			 }
		}
		catch(SQLException e)
		{
			e.toString();
		}
		finally
		{
			try
			{
				if(connect!=null)
				{
					connect.close();
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
		String requete;
		Statement stmt = null;
		
		try
		{
			stmt = connect.createStatement();
			requete = "select * from adresse";
			ResultSet rs = stmt.executeQuery(requete);
			
				while(rs.next())
				{
					uneAdresse = new Adresse(rs.getInt("id"),rs.getString("ville"),rs.getString("cp"),rs.getString("pays"),rs.getString("rue"));
					addresses.add(uneAdresse);
				}
			} catch (SQLException e) {
				
				System.out.println(e.toString());
				
			} finally {
			try { 
				if (stmt != null) stmt.close();
				if (connect != null) connect.close();}
			catch (SQLException e) { e.printStackTrace(); }
			}
		
		
		return addresses;
	}
}
