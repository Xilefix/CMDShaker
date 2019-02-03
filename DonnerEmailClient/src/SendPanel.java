import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendPanel extends JPanel implements ActionListener {
	//Schriftgröße und Art
    String Schriftyp ="Calibri"; 
 	int Schriftgr = 20; //x
	
 	//Variablen
	private JTextField emailEmpfaengerText,  subjectText ;
	private JTextArea textText;
    private JLabel emailEmpfaengerLabel, subjectLabel, textLabel ;
    private JButton SendButton = new JButton("Send");
    public String emailEmpfaenger, subject, text;
    
    
    
    public SendPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Labels
      //EmailEmpfänger
        emailEmpfaengerLabel = new JLabel("Empfaenger-Adressen(durch , getrennt):");
        displayPanel.add(emailEmpfaengerLabel);
        emailEmpfaengerLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        emailEmpfaengerText = new JTextField(80);
        displayPanel.add(emailEmpfaengerText);
        emailEmpfaengerText.setText("Felix.liesendahl@web.de");//x
        emailEmpfaengerText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));


        //Betreff
        subjectLabel = new JLabel("Betreff: ");
        displayPanel.add(subjectLabel);
        subjectLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        subjectText = new JTextField(80);
        displayPanel.add(subjectText);
        subjectText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));


        //Textkörper
        textLabel = new JLabel("Text: ");
        displayPanel.add(textLabel);
        textLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        textText = new JTextArea(30,75);
        displayPanel.add(textText);
        textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        
   
              
// button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

// Send button 
        
        SendButton.addActionListener(this);
        buttonPanel.add(SendButton);
        SendButton.setPreferredSize(new Dimension(150,150));
        SendButton.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        


// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == SendButton) {
            emailEmpfaenger = emailEmpfaengerText.getText();
            subject =  subjectText.getText();
            text = textText.getText();
            JOptionPane.showMessageDialog(null, "Bitte warten es sendet");//x

            ClientSend( emailEmpfaenger, subject, text); 
            //xx wie kann ich auf die Variablen aus der anderen Klasse zugreifen?
        }


    }

    public static void ClientSend(String emailEmpfaenger,String subject, String messageText) {
        	try {//String server,String name,String pw,String port,

            int i=1,c=0;

            String[] rcpt = {emailEmpfaenger};

            boolean sessionDebug = false;

            
        		
        	BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Public\\acc.txt"));
        	String in = read.readLine();        			
        			
        	String[] line = in.split(";");  			
        	String server=line[0];
        	String name = line[2];
        	String pw=line[3];
        	String port=line[4];
        	
        	
        	read.close();
        		
        		

            Properties props = System.getProperties();


            props.setProperty("mail.smtp.host", server);
            props.setProperty("mail.smtp.port",port);
            props.setProperty("mail.smtp.auth","true");
            if(port=="587") {
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.starttls.required","true");
            }
            else {
            props.setProperty("mail.smtp.starttls.enable","false");
            props.setProperty("mail.smtp.starttls.required","false");
            }
            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider() );

            Session emailSession = Session.getDefaultInstance(props);
            emailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(emailSession);
            msg.setFrom(new InternetAddress(name));



            InternetAddress[] address = new InternetAddress[rcpt.length];
            for (i = 0; i <= rcpt.length-1; i++)
                address[i] = new InternetAddress(rcpt[i]);

            msg.setRecipients(Message.RecipientType.TO,address);
            msg.setSubject(subject);
            msg.setText(messageText);

            Transport transport = emailSession.getTransport("smtp");
            transport.connect(server,name,pw);
            transport.sendMessage(msg, msg.getAllRecipients());


            JOptionPane.showMessageDialog(null, "Die Nachricht wurde verschickt.");

            transport.close();


        }catch(NoSuchProviderException nspe) {
            nspe.printStackTrace();
        }catch(MessagingException me) {
            me.printStackTrace();
        }catch (Exception e) {
    		e.printStackTrace();
    	}
    }


}