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

	public PhoneDAO()
	{
		
	}
	
	public void createPhoneDAO(Telephone t, Contact c)
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
					 requete = "INSERT INTO telephone(typeTelephone,numeroTelephone, fk_idContact_telephone) VALUES " + "('" + t.getType() +"','" + t.getNumero() + "','" + c.getId() +"')";
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
	
	public void ModifyPhoneDAO(String typeTel, String num, String idContact)
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
					 requete = "UPDATE telephone SET typeTelephone = '" + typeTel + "', numeroTelephone = '" + num + "' WHERE fk_idContact_telephone = '" + idContact + "'";
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
	
	public void DeletePhoneDAO(String id)
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
			 requete = "DELETE FROM telephone WHERE id = '" + id + "'";
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
	
	public void FetchPhoneDAO(String id)
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
			 requete = "SELECT * FROM telephone WHERE fk_idContact_telephone = '" + id  + "'";
			 ResultSet rs = stmt.executeQuery(requete);
			 while(rs.next())
			 {
				 System.out.println("Type : " + rs.getString("typeTelephone") +" \nNumero: " + rs.getString("numeroTelephone"));
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
	
	public ArrayList<Telephone> displayPhoneByContact()
	{
		ArrayList<Telephone> listephone = new ArrayList<Telephone>();
		String driver ="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/gestioncontact";
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
		return listephone;
	}
}
