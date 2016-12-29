package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Contact;

public class DAOContact {

	public Connection connect = null;
	public DAOContact()
	{
		connect = ConnectionDatabase.getInstance();
	}
	
	public Connection getConnection()
	{
		return ConnectionDatabase.getInstance();
	}
	public String createContact(int Did, String Dnom, String Dprenom, String Dmail)
	{

		String requete;
		Statement stmt = null;
		
		try {

			stmt = connect.createStatement();
			requete = "INSERT INTO Contact(id,nom,prenom,mail) VALUES " + "('" + Did +"','" + Dnom + "','" + Dprenom + "','" + Dmail + "')";
			int nb = stmt.executeUpdate(requete);
			System.out.println("Nombre de lignes mises à jour = " + nb);
			//return null;
			
			} 		catch(SQLException e)
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
		
		return null;
				

	}

	public String researchContact(int Did) {

		String requete;
		Statement stmt = null;
		
		try {connect = this.getConnection();
			stmt = connect.createStatement();
			requete = "SELECT * FROM Contact where id = '" + Did +"'";
			ResultSet rs = stmt.executeQuery(requete);
			
			while(rs.next())
			{
				System.out.println("Id : " + rs.getString("id") +
								"\n Nom : "+ rs.getString("nom")+
								"\n Prenom :" + rs.getString("prenom") +
								"\n Mail:" + rs.getString("mail"));
			}
					
			
			}		catch(SQLException e)
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
		return null;
	}

	public String updateContact(int Did, String Dnom, String Dprenom, String Dmail) {
		// TODO Auto-generated method stub

		String requete;
		Statement stmt = null;
		
		try {connect = this.getConnection();
			stmt = connect.createStatement();
			requete = "UPDATE Contact SET nom='"+Dnom+"',prenom='"+Dprenom+"',mail='"+Dmail+"' WHERE id='"+Did+"'";
			int nb = stmt.executeUpdate(requete);
			System.out.println("nb de ligne ajouté="+nb);
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
		return null;
	}

	public String deleteContact(int Did) {
		// TODO Auto-generated method stub

		String requete;

		Statement stmt = null;
		
		try {
			connect = this.getConnection();
			stmt = connect.createStatement();
			requete = "DELETE FROM Contact where id='"+ Did +"'";
			int nb = stmt.executeUpdate(requete);
			System.out.println("nb de ligne supprimé="+nb +"/n id du contact supprimé" + Did);
			
					
			} 		catch(SQLException e)
		{System.out.println("fais chier 3");
				System.out.println(e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); System.out.println("fais chier 4");
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
		return null;
	}
	
	public ArrayList<Contact> listContacts(){
		ArrayList<Contact> liste = new ArrayList<Contact>();

		String requete;

		Statement stmt = null;
		
		try
		{
			connect = this.getConnection();
			stmt = connect.createStatement();
			requete = "select * from contact";
			ResultSet rs = stmt.executeQuery(requete);
			
				while(rs.next())
				{
					int id = rs.getInt("id");
					String lastName = rs.getString("nom");
					String firstName = rs.getString("prenom");
					String email = rs.getString("mail");
					
					liste.add(new Contact(id, lastName, firstName, email));
				}
			}
			catch(SQLException e){ System.out.println(e.getMessage()); System.out.println("fais chier 2");}
			catch(Exception e)
			{
				System.out.println("fais chier 1");
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
		
		return liste;
		
	}

}
