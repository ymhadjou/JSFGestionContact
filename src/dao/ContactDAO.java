package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ContactDAO {
	public Connection connect = ConnectionDatabase.getInstance();
	public ContactDAO()
	{

			
	}
	
	
	public void CreateContactDAO(String lastname, String name, String mail, String id, String street, String city, String zip, String country)
	{

		String requete="";
		Statement stmt = null;
		
		try
		{

			//Statement
			 stmt = connect.createStatement();
			 requete = "INSERT INTO Contact(id,nom,prenom,mail) VALUES " + "('" + id +"','" + lastname + "','" + name + "','" + mail + "')";
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
	
	
	public void ModifyContactDAO(String lastname, String name, String mail, String id)
	{
		String requete="";
		Statement stmt = null;
		try
		{

			//Statement
			 stmt = connect.createStatement();
			 requete = "UPDATE Contact SET nom = '" + lastname + "', prenom = '" + name + "', mail = '" + mail + "' WHERE id = '" + id + "'";
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
	
	public void DeleteContactDAO(String id)
	{
		String requete="";
		Statement stmt = null;
			try
			{

				//Statement
				 stmt = connect.createStatement();
				 requete = "DELETE FROM Contact WHERE id = '" + id + "'";
				 int nb = stmt.executeUpdate(requete);
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
	
	public void FetchContactDAO(String id)
	{

		String requete="";
		Statement stmt = null;
		try
		{

			//Statement
			 stmt = connect.createStatement();
			 requete = "SELECT * FROM Contact WHERE ID = '" + id  + "'";
			 ResultSet rs = stmt.executeQuery(requete);
			 while(rs.next())
			 {
				 System.out.println("Nom : " + rs.getString("nom") +" \nPrenom : " + rs.getString("prenom") + "\nMail : " + rs.getString("mail"));
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
}
