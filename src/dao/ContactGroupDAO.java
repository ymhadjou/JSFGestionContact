package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactGroupDAO {
	
	public ContactGroupDAO()
	{
		
	}
	
	public void CreateGroupDAO(String nomGroupe)
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
			 requete = "INSERT INTO groupe(nomGroupe) VALUES " + "('" + nomGroupe +"')";
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
	
	public void ModifyGroupDAO(String id, String nomGroupe)
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
			 requete = "UPDATE groupe SET nomGroupe = '" + nomGroupe + "' WHERE idGroupe = '" + id + "'";
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
	
	public void DeleteGroupDAO(String id)
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
					 requete = "DELETE FROM groupe WHERE idGroupe = '" + id + "'";
					 System.out.println(requete);
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
	
	public void AddContactToGroupDAO(String idContact, String idGroupe)
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
					 requete = "INSERT INTO contact_groupe(idGroupe, idContact) VALUES " + "('" + idGroupe +"','"+idContact+"')";
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
	
	public void DeleteContactFromGroupDAO(String idContact, String idGroupe)
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
							 requete = "DELETE FROM contact_groupe WHERE idGroupe = '" + idGroupe + "' AND idContact = '" + idContact + "'";
							 System.out.println(requete);
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
}
