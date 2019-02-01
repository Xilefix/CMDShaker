import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccPanel extends JPanel implements ActionListener {
	private static JTextField emailAbsenderText, passwortText, sendServerText, recServerText, benutzerText, portText  ;
    private JLabel emailAbsenderLabel, passwortLabel, sendServerLable, recServerLable, benutzerLable, portLable;
    private JButton OKButton = new JButton("OK");
    public String sendServer;
	public String recServer;
	public String name;
	public String passwort;
    

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
        sendServerLable = new JLabel("SMTP-Server:");
        displayPanel.add(sendServerLable);
        
        sendServerText = new JTextField(30);
        displayPanel.add(sendServerText);
        
        //POP3
        recServerLable = new JLabel("POP3-Server: ");
        displayPanel.add(recServerLable);
        
        recServerText = new JTextField(30);
        displayPanel.add(recServerText);
        
        //Benutzer
        benutzerLable = new JLabel("Benutzer:");
        displayPanel.add(benutzerLable);
        
        benutzerText = new JTextField(30);
        displayPanel.add(benutzerText);
        
        

        
        
        
        
      //Port
        portLable = new JLabel("Port: ");
        displayPanel.add(portLable);
        
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
        	
        	
        		
        	
        	}
        	//char[] input = (JPasswordField)passwordField.getPassword();
			//String password = new String(passwort.getPassword());
            //JOptionPane.showMessageDialog(null, "Password is " + password);
        	
        	
        	
        	
        	//String pw = new String(pass);
        	
        	
        	//String pw = new String(((JPasswordField) passwortText).getPassword()); 
        	//http://www.zentut.com/java-swing/creating-password-field-by-using-jpasswordfield-class/
        	String port = portText.getText();
        	JOptionPane.showMessageDialog(null, "Gesichert");
        	
            
        }
        
                      
    
    
}