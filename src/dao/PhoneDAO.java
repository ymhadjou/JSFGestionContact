package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Contact;
import domain.Telephone;

public class PhoneDAO {
	
	public Connection connect = null;
	
	public PhoneDAO()
	{
		connect = ConnectionDatabase.getInstance();
	}
	
	public Connection getConnection()
	{
		return ConnectionDatabase.getInstance();
	}
	public void createPhoneDAO(Telephone t, Contact c)
	{

				String requete="";
				Statement stmt = null;
				
				try
				{connect = this.getConnection();
					//Statement
					 stmt = connect.createStatement();
					 requete = "INSERT INTO telephone(typeTelephone,numeroTelephone, fk_idContact_telephone) VALUES " + "('" + t.getType() +"','" + t.getNumero() + "','" + c.getId() +"')";
					 System.out.println(requete);
					 int nb = stmt.executeUpdate(requete);
					 System.out.println("Nombre de lignes mises à jour = " + nb);

				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				/*finally
				{
					try {
						if(stmt != null) stmt.close();
						if(connect != null) connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
		}
	
	public void ModifyPhoneDAO(String typeTel, String num, String idContact)
	{
				String requete="";
				Statement stmt = null;
				try
				{connect = this.getConnection();
					//Statement
					 stmt = connect.createStatement();
					 requete = "UPDATE telephone SET typeTelephone = '" + typeTel + "', numeroTelephone = '" + num + "' WHERE fk_idContact_telephone = '" + idContact + "'";
					 System.out.println(requete);
					 int nb = stmt.executeUpdate(requete);
					 System.out.println("Nombre de lignes affectées = " + nb);
					 
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				/*finally
				{
					try {
						if(stmt != null) stmt.close();
						if(connect != null) connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
		}
	
	public void DeletePhoneDAO(String id)
	{
		String requete="";
		Statement stmt = null;
		try
		{	connect = this.getConnection();
			//Statement
			 stmt = connect.createStatement();
			 requete = "DELETE FROM telephone WHERE id = '" + id + "'";
			 int nb = stmt.executeUpdate(requete);
			 System.out.println("Nombre de lignes supprimées = " + nb);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	/*	finally
		{
			try {
				if(stmt != null) stmt.close();
				if(connect != null) connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	
	public void FetchPhoneDAO(String id)
	{
		String requete="";
		Statement stmt = null;
		try
		{connect = this.getConnection();
			//Statement
			 stmt = connect.createStatement();
			 requete = "SELECT * FROM telephone WHERE fk_idContact_telephone = '" + id  + "'";
			 ResultSet rs = stmt.executeQuery(requete);
			 while(rs.next())
			 {
				 System.out.println("Type : " + rs.getString("typeTelephone") +" \nNumero: " + rs.getString("numeroTelephone"));
			 }
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				if(stmt != null) stmt.close();
				if(connect != null) connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Telephone> displayPhoneByContact()
	{
		ArrayList<Telephone> listephone = new ArrayList<Telephone>();
		String requete="";
		Statement stmt = null;
		try
		{connect = this.getConnection();
			//Statement
			 stmt = connect.createStatement();
			 requete = "select c.nom, c.prenom, t.id, t.numeroTelephone from contact c, telephone t where c.id= t.fk_idContact_telephone";
			 ResultSet rs = stmt.executeQuery(requete);
				
				while(rs.next())
				{
					Contact c = new Contact(rs.getString("c.nom"), rs.getString("c.prenom"));
					int idTelephone = rs.getInt("t.id");
					String num = rs.getString("t.numeroTelephone");
					listephone.add(new Telephone(rs.getInt("t.id"),rs.getInt("t.numeroTelephone"),c));
				}

		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		/*finally
		{
			try {
				if(stmt != null) stmt.close();
				if(connect != null) connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		return listephone;
	}
}
