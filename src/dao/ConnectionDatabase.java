package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class ConnectionDatabase {
	
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/gestioncontact";
	//String url = "jdbc:mysql://localhost:3306/GestionContact?useSSL=false";
	static String uid = "root"; 
	static String passwd = "";
	
	private static Connection connect;
	
	public static Connection getInstance(){
		if(connect == null){
			try {
				Class.forName(driver);
				connect = DriverManager.getConnection(url, uid, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return connect;	
	}
	

}
