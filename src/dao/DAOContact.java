package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Contact;

public class DAOContact {

	
	public DAOContact()
	{

	}
	
	public String createContact(int Did, String Dnom, String Dprenom, String Dmail)
	{
		//System.out.println("Le contact -" + Dnom + "- a été créé.");
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/gestioncontact?useSSL=false";
		String uid = "root"; String passwd = "root";
		String requete;
		Connection cx = null;
		Statement stmt = null;
		
		try {
			
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.createStatement();
			requete = "INSERT INTO Contact(id,nom,prenom,mail) VALUES " + "('" + Did +"','" + Dnom + "','" + Dprenom + "','" + Dmail + "')";
			int nb = stmt.executeUpdate(requete);
			System.out.println("Nombre de lignes mises à jour = " + nb);
			//return null;
			
			} catch (ClassNotFoundException e) {
				
				// classe du pilote introuvable
				
			} catch (SQLException e) {
				return e.toString();
			} finally {
			try { 
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();}
			catch (SQLException e) { e.printStackTrace(); }
			
			}
		
		return null;
				

	}

	public String researchContact(int Did) {
		// TODO Auto-generated method stub
		//System.out.println("Le contact -" + Dnom + "- a été créé.");
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/gestioncontact";
		String uid = "root"; String passwd = "";
		String requete;
		Connection cx = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.createStatement();
			requete = "SELECT * FROM Contact where id = '" + Did +"'";
			ResultSet rs = stmt.executeQuery(requete);
			
			while(rs.next())
			{
				System.out.println("Id : " + rs.getString("id") +
								"\n Nom : "+ rs.getString("nom")+
								"\n Prenom :" + rs.getString("prenom") +
								"\n Mail:" + rs.getString("mail"));
			}
					
			
			} catch (ClassNotFoundException e) {
				
				// classe du pilote introuvable
				
			} catch (SQLException e) {
				
				System.out.println(e.toString());
				
			} finally {
			try { 
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();}
			catch (SQLException e) { e.printStackTrace(); }
			}
		return null;
	}

	public String updateContact(int Did, String Dnom, String Dprenom, String Dmail) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/gestioncontact?useSSL=false";
		String uid = "root"; String passwd = "root";
		String requete;
		Connection cx = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.createStatement();
			requete = "UPDATE Contact SET nom='"+Dnom+"',prenom='"+Dprenom+"',mail='"+Dmail+"' WHERE id='"+Did+"'";
			int nb = stmt.executeUpdate(requete);
			System.out.println("nb de ligne ajouté="+nb);
					
			
			} catch (ClassNotFoundException e) {
				
				// classe du pilote introuvable
				
			} catch (SQLException e) {
				
				System.out.println(e.toString());
				
			} finally {
			try { 
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();}
			catch (SQLException e) { e.printStackTrace(); }
			}
		return null;
	}

	public String deleteContact(int Did) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/gestioncontact?useSSL=false";
		String uid = "root"; String passwd = "root";
		String requete;
		Connection cx = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.createStatement();
			requete = "DELETE FROM Contact where id='"+ Did +"'";
			int nb = stmt.executeUpdate(requete);
			System.out.println("nb de ligne supprimé="+nb +"/n id du contact supprimé" + Did);
			
					
			} catch (ClassNotFoundException e) {
				
				// classe du pilote introuvable
				
			} catch (SQLException e) {
				
				System.out.println(e.toString());
				
			} finally {
			try { 
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();}
			catch (SQLException e) { e.printStackTrace(); }
			}
		return null;
	}
	
	public ArrayList<Contact> listContacts(){
		ArrayList<Contact> liste = new ArrayList<Contact>();
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/gestioncontact?useSSL=false";
		String uid = "root"; String passwd = "root";
		String requete;
		Connection cx = null;
		Statement stmt = null;
		
		try
		{
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.createStatement();
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
			} catch (ClassNotFoundException e) {
				
				// classe du pilote introuvable
				
			} catch (SQLException e) {
				
				System.out.println(e.toString());
				
			} finally {
			try { 
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();}
			catch (SQLException e) { e.printStackTrace(); }
			}
		
		
		return liste;
		
	}

}
