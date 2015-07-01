import java.awt.Dimension;

import javax.swing.*;


public class Database extends JPanel { //Make it a JPanel so it fits in the JFrame
	static JTextArea sql = new JTextArea(); //text area for SQL query
	JLabel prompt = new JLabel("Please enter your SQL statement  below: "); //tells the user what to enter
	JButton exe = new JButton("Execute");
	JButton reset = new JButton("Reset");
	static JTable table = new JTable(); // to display results
	
	public Database(){
		add(prompt);
		JScrollPane spane = new JScrollPane(sql); //makes sql text area into a scroll pane
		spane.setPreferredSize(new Dimension(750, 100));
		add(spane); 
		
		add(exe);
		add(reset);
		
		JScrollPane rpane = new JScrollPane(table); //allow to scroll through results table
		rpane.setPreferredSize(new Dimension(750, 400));
		add(rpane); 
	}
}
