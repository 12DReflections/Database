import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.Statement;

//A class that connects to the database
public class Connector {
	Connection conn;
	Statement stat;
	static String url, database, username, password, hostname, port, driver;
	
	public Connector(Properties props, String pass){
		database = props.getProperty("Database"); //take information from the properties
		username = props.getProperty("User_Name");
		password = pass;
		hostname = props.getProperty("Host_Name");
		port = props.getProperty("Port");
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
	}
	
	//Method to open Connection
	public boolean open(){
		try {
			DriverManager.registerDriver((java.sql.Driver) Class.forName(driver).newInstance());//Cast Driver to class, create a new instance
			conn = DriverManager.getConnection(url, username, password);//get the connection
			stat = conn.createStatement(); 
		} catch (Exception e) {
			e.printStackTrace();
			if(conn == null)
				return false;
		} 
		System.out.println("Connection Established");
		return true;
	}
}
