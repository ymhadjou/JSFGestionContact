package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactGroupDAO {
	public Connection connect = null;
	public ContactGroupDAO()
	{
		connect = ConnectionDatabase.getInstance();
	}
	public Connection getConnection()
	{
		return ConnectionDatabase.getInstance();
	}
	public void CreateGroupDAO(String nomGroupe)
	{
		String requete="";
		Statement stmt = null;
		
		try
		{
			//Statement
			 stmt = connect.createStatement();
			 requete = "INSERT INTO groupe(nomGroupe) VALUES " + "('" + nomGroupe +"')";
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
	
	public void ModifyGroupDAO(String id, String nomGroupe)
	{
		//Configuration
		String requete="";
		Statement stmt = null;
		try
		{connect = this.getConnection();
			//Statement
			 stmt = connect.createStatement();
			 requete = "UPDATE groupe SET nomGroupe = '" + nomGroupe + "' WHERE idGroupe = '" + id + "'";
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
	
	public void DeleteGroupDAO(String id)
	{
		String requete="";
		Statement stmt = null;
				try
				{connect = this.getConnection();
					//Statement
					 stmt = connect.createStatement();
					 requete = "DELETE FROM groupe WHERE idGroupe = '" + id + "'";
					 System.out.println(requete);
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
	
	public void AddContactToGroupDAO(String idContact, String idGroupe)
	{
				String requete="";
				Statement stmt = null;
				
				try
				{	connect = this.getConnection();
					//Statement
					 stmt = connect.createStatement();
					 requete = "INSERT INTO contact_groupe(idGroupe, idContact) VALUES " + "('" + idGroupe +"','"+idContact+"')";
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
		/*		finally
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
	
	public void DeleteContactFromGroupDAO(String idContact, String idGroupe)
	{
				String requete="";
				Statement stmt = null;
						try
						{	connect = this.getConnection();
							//Statement
							 stmt = connect.createStatement();
							 requete = "DELETE FROM contact_groupe WHERE idGroupe = '" + idGroupe + "' AND idContact = '" + idContact + "'";
							 System.out.println(requete);
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
}
