package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ContactDAO {
	
	public ContactDAO()
	{

			
	}
	
	
	public void CreateContactDAO(String lastname, String name, String mail, String id, String street, String city, String zip, String country)
	{
		//Configuration
		String driver ="com.mysql.jdbc.Driver";
		//String url ="jdbc:mysql://localhost:3306/GestionContact?useSSL=false";
		//String user ="root";
		//String password ="root";
		String url = "jdbc:mysql://localhost:3306/GestionContact?useSSL=false";
		String user ="root";
		String password ="";
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
			 requete = "INSERT INTO Contact(id,nom,prenom,mail) VALUES " + "('" + id +"','" + lastname + "','" + name + "','" + mail + "')";
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
	
	
	public void ModifyContactDAO(String lastname, String name, String mail, String id)
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
			 requete = "UPDATE Contact SET nom = '" + lastname + "', prenom = '" + name + "', mail = '" + mail + "' WHERE id = '" + id + "'";
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
	
	public void DeleteContactDAO(String id)
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
				 requete = "DELETE FROM Contact WHERE id = '" + id + "'";
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
	
	public void FetchContactDAO(String id)
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
			 requete = "SELECT * FROM Contact WHERE ID = '" + id  + "'";
			 ResultSet rs = stmt.executeQuery(requete);
			 while(rs.next())
			 {
				 System.out.println("Nom : " + rs.getString("nom") +" \nPrenom : " + rs.getString("prenom") + "\nMail : " + rs.getString("mail"));
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
