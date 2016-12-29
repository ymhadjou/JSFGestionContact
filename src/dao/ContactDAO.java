package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ContactDAO {
	public Connection connect = null;
	public ContactDAO()
	{
		 connect = ConnectionDatabase.getInstance();
			
	}
	public Connection getConnection()
	{
		return ConnectionDatabase.getInstance();
	}
	
	public void CreateContactDAO(String lastname, String name, String mail, String id, String street, String city, String zip, String country)
	{

		String requete="";
		Statement stmt = null;
		
		try
		{
			connect = this.getConnection();
			//Statement
			 stmt = connect.createStatement();
			 requete = "INSERT INTO Contact(id,nom,prenom,mail) VALUES " + "('" + id +"','" + lastname + "','" + name + "','" + mail + "')";
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
	
	
	public void ModifyContactDAO(String lastname, String name, String mail, String id)
	{
		String requete="";
		Statement stmt = null;
		try
		{
			connect = this.getConnection();
			//Statement
			 stmt = connect.createStatement();
			 requete = "UPDATE Contact SET nom = '" + lastname + "', prenom = '" + name + "', mail = '" + mail + "' WHERE id = '" + id + "'";
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
	
	public void DeleteContactDAO(String id)
	{
		String requete="";
		Statement stmt = null;
			try
			{
				connect = this.getConnection();
				//Statement
				 stmt = connect.createStatement();
				 requete = "DELETE FROM Contact WHERE id = '" + id + "'";
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
	
	public void FetchContactDAO(String id)
	{

		String requete="";
		Statement stmt = null;
		try
		{
			connect = this.getConnection();
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
}
