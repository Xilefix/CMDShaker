
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AccPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Schriftgröße und Art
    String Schriftyp ="Calibri"; 
 	int Schriftgr = 20; 
	
 	//Variablen
	private JTextField emailAbsenderText, sendServerText, recServerText, benutzerText, smtpportText, pop3portText ;
    private JLabel emailAbsenderLabel, passwortLabel, sendServerLabel, recServerLabel, benutzerLabel, smtpportLabel, pop3portLabel;
    private JPasswordField passwortText;
    private JButton OKButton = new JButton("OK");
    private JCheckBox ZeigePasswort = new JCheckBox("Passwort anzeigen");
    public String sendServer= "";
	public String recServer= "";
	public String name= "";
	public String passwort= "";
	public String smtpport= "";
	public String pop3port= "";
	

	
    

    public AccPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Labels
        //EmailAbsender
        emailAbsenderLabel = new JLabel("E-mail Absender:");
        displayPanel.add(emailAbsenderLabel);
        emailAbsenderLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        emailAbsenderText = new JTextField(30);
        displayPanel.add(emailAbsenderText);
        emailAbsenderText.setText("unijena123@firemail.de");
        emailAbsenderText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        //Passwort
        passwortLabel = new JLabel("Passwort: ");
        displayPanel.add(passwortLabel);
        passwortLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        
        passwortText = new JPasswordField(30);
        passwortText.setEchoChar('*');
        
        /*passwortText = new JTextField(30);*/
        displayPanel.add(passwortText);
        passwortText.setText("Felix#jena1");//x
        passwortText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));//x
        
        
       
        
                          
         
					
				         
         
        //SMTP
        sendServerLabel = new JLabel("SMTP-Server:");
        displayPanel.add(sendServerLabel);
        sendServerLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        sendServerText = new JTextField(30);
        displayPanel.add(sendServerText);
        sendServerText.setText("smtp.firemail.de");//x
        sendServerText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        //POP3
        recServerLabel = new JLabel("POP3-Server: ");
        displayPanel.add(recServerLabel);
        recServerLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
                
        recServerText = new JTextField(30);
        displayPanel.add(recServerText);
        recServerText.setText("pop3.firemail.de");//x
        recServerText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        //Benutzer
        benutzerLabel = new JLabel("Benutzer:");
        displayPanel.add(benutzerLabel);
        benutzerLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        benutzerText = new JTextField(30);
        displayPanel.add(benutzerText);
        benutzerText.setText("unijena123@firemail.de");//x
        benutzerText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        

        
        
        
        
        //smtp Port
        smtpportLabel = new JLabel("smtp-Port: ");
        displayPanel.add(smtpportLabel);
        smtpportLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        smtpportText = new JTextField(7);
        displayPanel.add(smtpportText);
        smtpportText.setText("587");
        smtpportText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        
        //pop3 Port
        pop3portLabel = new JLabel("pop3-Port: ");
        displayPanel.add(pop3portLabel);
        pop3portLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        pop3portText = new JTextField(7);
        displayPanel.add(pop3portText);
        pop3portText.setText("110");
        pop3portText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
              
        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

        // OK button 
        
        OKButton.addActionListener(this);
        OKButton.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        OKButton.setPreferredSize(new Dimension(100,100));//x
        buttonPanel.add(OKButton);
        
     // Checkbox Passwort anzeigen 
        ZeigePasswort.addActionListener(this);
        ZeigePasswort.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        ZeigePasswort.setPreferredSize(new Dimension(200,200));//x
        buttonPanel.add(ZeigePasswort);

        


// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
    public void actionPerformed(ActionEvent e)  {

        Object source = e.getSource();
        if (source == ZeigePasswort) {
        	if(ZeigePasswort.isSelected())
        	passwortText.setEchoChar((char)0);
        	else
        	passwortText.setEchoChar('*');
        	
        }
        if (source == OKButton) {
        	sendServer = sendServerText.getText();
        	recServer =  recServerText.getText();
        	name = emailAbsenderText.getText();
        	
        	char [] pass = passwortText.getPassword();
        	for (int x = 0; x< pass.length; x++) {
        		passwort+=pass[x];
        	}
        	//passwortText.setEchoChar((char)0);
        	
        	
        	//passwort = passwortText.getText();
        	smtpport = smtpportText.getText();
        	pop3port = pop3portText.getText();
        	
        	
        	
        	File mailAcc=new File("C:\\Users\\Public"+"\\acc.txt");		//Windows
        	//File mailAcc=new File("C:\\Users\\Public"+"\\acc.txt");  //Linux
        											
			try {
			    BufferedWriter writer = new BufferedWriter(new FileWriter(mailAcc));	//Meldung "The local variable mailAcc may not have been initialized" ignorieren
			    
			    writer.write(sendServer+ ";"); 
			    writer.write(recServer+ ";");	
			    writer.write(name+ ";");
			    writer.write(passwort+ ";");
			    writer.write(smtpport+ ";");
			    writer.write(pop3port+ ";");
			    
			    
				writer.newLine(); // <-----------------
				writer.close();
			}
			catch (IOException e1) {
			e1.printStackTrace();
			}
        		
			JOptionPane.showMessageDialog(null, "Gesichert");
        	}
        	 
        	//http://www.zentut.com/java-swing/creating-password-field-by-using-jpasswordfield-class/
        	
        	
        	
            
        }
        
  
}