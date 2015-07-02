import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.*;


public class ConnectDialogue extends JDialog implements ActionListener {

	boolean isCancelled = true; //Keeps track of once user has pressed OK 
	JLabel lhost = new JLabel("Host Name");
	JTextField host = new JTextField();
	JLabel lport = new JLabel("Port"); //label for the port
	JTextField port = new JTextField();
	JLabel ldatabase = new JLabel("Database");
	JTextField database = new JTextField();
	JLabel luser = new JLabel("User Name");
	JTextField user = new JTextField();
	JLabel lpass = new JLabel("Password");
	JPasswordField pass = new JPasswordField(); //Special passwordfield
	
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	
	Properties props; //Properties object allows to send all the properties of the database as an object
	
	public ConnectDialogue(JFrame owner, String title, Properties p){
		super(owner, title, true);
		setSize(300, 200);
		setLocation(250,200);
		props = new Properties(p); //set properties in this class to the ones passed in
		ok.setPreferredSize(new Dimension(75,25));
		ok.addActionListener(this);
		cancel.setPreferredSize(new Dimension(75,25));
		cancel.addActionListener(this);
		
		JPanel cpanel = new JPanel(); //Grid layout with text fields
		JPanel cpanel2 = new JPanel();
		
		//Add items to the Content Panel
		cpanel.setLayout(new GridLayout(5,2));
		
		cpanel.add(lhost);
		cpanel.add(host);
		cpanel.add(lport);
		cpanel.add(port);
		cpanel.add(ldatabase);
		cpanel.add(database);
		cpanel.add(luser);
		cpanel.add(user);
		cpanel.add(lpass);
		cpanel.add(pass);
		
		cpanel2.add(ok);
		cpanel2.add(cancel);
		
		add(cpanel, BorderLayout.NORTH);
		add(cpanel2, BorderLayout.SOUTH);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok){
			isCancelled = false; 
			
			this.dispose();
		}
	}
	
	public Properties getProps(){
		props.setProperty("Database", database.getText());
		props.setProperty("Host_Name", host.getText());
		props.setProperty("Port", port.getText());
		props.setProperty("User_Name", user.getText());
		return props;
	}
}
