import java.util.*;

import javax.swing.*;

/**
 * Database Management System in Java and MySQL
 * 
 * Database Management System programmed an annotated by Julian Wise
 * following Eduonix Tutorial "Projects in Java"
 *
 *Classes
 *Main Class - connects everything together
 *Database Class - displays records and executes queries
 *Connector Class - connects to the database
 *Connect Dialogue - prompts User for information
 */

public class Main {
	public static void main(String[] args){
		
		//Database JFrame Setup
		JFrame frame = new JFrame("Database");
		Properties props = new Properties();	//Property is a subclass of hashtable, suitable for a key of a string with a variable of a string
		ConnectDialogue dialogue = new ConnectDialogue(frame, "Database Connector", props); //frame, title, property
		dialogue.setVisible(true);
		if(dialogue.isCancelled) //cancel not working
			System.exit(0);
		
		Connector conn = new Connector(dialogue.getProps(), new String(dialogue.pass.getPassword()));
		if(!conn.open())
			System.exit(0);
		
		Database dpanel = new Database(conn);
		frame.setSize(800,600);
		frame.add(dpanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
