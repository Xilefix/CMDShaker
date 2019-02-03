
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccPanel extends JPanel implements ActionListener {
	private static JTextField emailAbsenderText, passwortText, sendServerText, recServerText, benutzerText, portText ;
    private JLabel emailAbsenderLabel, passwortLabel, sendServerLabel, recServerLabel, benutzerLabel, portLabel;
    private JButton OKButton = new JButton("OK");
    public String sendServer;
	public String recServer;
	public String name;
	public String passwort;
	public String port;
	
    

    public AccPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Labels
        //EmailAbsender
        emailAbsenderLabel = new JLabel("E-mail Absender:");
        displayPanel.add(emailAbsenderLabel);
        
        emailAbsenderText = new JTextField(30);
        displayPanel.add(emailAbsenderText);
        
        //Passwort
        passwortLabel = new JLabel("Passwort: ");
        displayPanel.add(passwortLabel);
        
        passwortText = new JTextField(30);
        displayPanel.add(passwortText);
        //passwortLabel.add(passwortText);
        
        //displayPanel.add(passwortText);
        //JPasswordField passwordField;
        //passwordField = new JPasswordField(30);
        //passwordField.addActionListener(this);
         //passwort.setEchoChar('*');
        //final JPasswordField passwort = new JPasswordField(20);
        
                          
         
					
				         
         
        //SMTP
        sendServerLabel = new JLabel("SMTP-Server:");
        displayPanel.add(sendServerLabel);
        
        sendServerText = new JTextField(30);
        displayPanel.add(sendServerText);
        
        //POP3
        recServerLabel = new JLabel("POP3-Server: ");
        displayPanel.add(recServerLabel);
        
        recServerText = new JTextField(30);
        displayPanel.add(recServerText);
        
        //Benutzer
        benutzerLabel = new JLabel("Benutzer:");
        displayPanel.add(benutzerLabel);
        
        benutzerText = new JTextField(30);
        displayPanel.add(benutzerText);
        
        

        
        
        
        
        //Port
        portLabel = new JLabel("Port: ");
        displayPanel.add(portLabel);
        
        portText = new JTextField(7);
        displayPanel.add(portText);
        portText.setText("587");   
              
        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

        // OK button 
        
        OKButton.addActionListener(this);
        buttonPanel.add(OKButton);

        


// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
    public void actionPerformed(ActionEvent e)  {

        Object source = e.getSource();
       
        if (source == OKButton) {
        	sendServer = sendServerText.getText();
        	recServer =  recServerText.getText();
        	name = emailAbsenderText.getText();
        	passwort = passwortText.getText();
        	port = portText.getText();
        	
        	
        	File mailAcc=new File("C:\\Users\\Public"+"\\acc.txt");
        	
        											
			try {
			    BufferedWriter writer = new BufferedWriter(new FileWriter(mailAcc));	//Meldung "The local variable mailAcc may not have been initialized" ignorieren
			    
			    writer.write(sendServer+ ";"); 
			    writer.write(recServer+ ";");	
			    writer.write(name+ ";");
			    writer.write(passwort+ ";");
			    writer.write(port+ ";");
			    
			    
				writer.newLine(); // <-----------------
				writer.close();
			}
			catch (IOException e1) {
			e1.printStackTrace();
			}
        		
        	
        	}
        	//char[] input = (JPasswordField)passwordField.getPassword();
			//String password = new String(passwort.getPassword());
            //JOptionPane.showMessageDialog(null, "Password is " + password);
        	
        	
        	
        	
        	//String pw = new String(pass);
        	
        	
        	//String pw = new String(((JPasswordField) passwortText).getPassword()); 
        	//http://www.zentut.com/java-swing/creating-password-field-by-using-jpasswordfield-class/
        	
        	JOptionPane.showMessageDialog(null, "Gesichert");
        	
            
        }
        
  
}