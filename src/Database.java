import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Database extends JPanel { //Make it a JPanel so it fits in the JFrame
	static JTextArea sql = new JTextArea(); //text area for SQL query
	JLabel prompt = new JLabel("Please enter your SQL statement  below: "); //tells the user what to enter
	JButton exe = new JButton("Execute");
	JButton reset = new JButton("Reset");
	static JTable table = new JTable(); // to display results
	static DefaultTableModel model = (DefaultTableModel) table.getModel();//Take a model of the table

	static Connector dc;
	
	public Database(Connector conn){ //Pass the connection into the Database
		add(prompt);
		dc = conn;
		JScrollPane spane = new JScrollPane(sql); //makes sql text area into a scroll pane
		spane.setPreferredSize(new Dimension(750, 100));
		add(spane); 
		exe.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				execute();
			}
			
		});
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setColumnCount(0);
				model.setRowCount(0);
			}
			
		});
		
		add(exe);
		add(reset);
		
		JScrollPane rpane = new JScrollPane(table); //allow to scroll through results table
		rpane.setPreferredSize(new Dimension(750, 400));
		add(rpane); 
	}
	
	private static void execute(){
		model.setColumnCount(0);
		model.setRowCount(0);
		String s = sql.getText();
		try{
			if((s.length()>=6 && s.substring(0,6).equalsIgnoreCase("SELECT"))){ //if first 6 letters = select, run a query
				ResultSet rs =dc.executeQuery(s); //returns results of query
				
				//Get the Columns from the MetaData
				ResultSetMetaData rsmd = rs.getMetaData(); //metadata provides number of columns
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					model.addColumn(rsmd.getColumnName(i));
				}
				while(rs.next()){
					String[] data = new String[rsmd.getColumnCount()];
					for(int i = 1; i <= rsmd.getColumnCount(); i++){
						data[i-1] = rs.getString((i)); //Stores string to data array 
					}
					model.addRow(data); //add a row and pass it the String Array
					}
			}
			else
				dc.executeUpdate(s); 
			
			//upload table to JFrame
		}catch(SQLException e){
			System.out.println("Error: " + e);
			
		}
	}
	
	
	
	
	
}
