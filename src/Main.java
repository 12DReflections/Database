import javax.swing.*;

/**
 * 
 * @author Julian
 *
 *Connect Dialogue 
 *Main Class connects everything together, launches JFrame
 *Database Class displays records and executes queries
 *Connector which connects to the database
 *Connect Dialogue -Prompts User for information
 */

public class Main {
	public static void main(String[] args){
		
		//Database JFrame Setup
		JFrame frame = new JFrame("Database");
		
		Database dpanel = new Database();
		
		frame.setSize(800,600);
		frame.add(dpanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
