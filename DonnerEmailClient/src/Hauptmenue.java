
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.mail.internet.*;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.*;
import java.util.Properties;

public class Hauptmenue{
	
	
	public static void main(String[] args) {
		JFrame MainFrame = new FrameHaupt();
	    MainFrame.setVisible(true);
	    
	    
	}
}

		


class FrameHaupt extends JFrame implements ActionListener{
	public FrameHaupt() {
		setTitle("DonnerEmailClient");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(d);
		centerWindow(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new HauptPanel();
        this.add(panel);
        
        // Erzeugen der Menüleiste und Hinzufügen der Menüs
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        menuBar = new JMenuBar();
     	menu = new JMenu("File");
     	menu.setMnemonic(KeyEvent.VK_A);
     	menu.getAccessibleContext().setAccessibleDescription("Filemenue");
     	menuBar.add(menu);
     		
     	//JMenuItems
     	menuItem = new JMenuItem("neue eMail", KeyEvent.VK_T);
     	menu.add(menuItem);
     	menuItem.addActionListener(this);
     	menuItem = new JMenuItem("Empfangen", KeyEvent.VK_T);
     	menu.add(menuItem);
     	menuItem.addActionListener(this);
     	menuItem = new JMenuItem("Optionen", KeyEvent.VK_T);
     	menu.add(menuItem);
     	menuItem.addActionListener(this);
     	menuItem = new JMenuItem("Beenden", KeyEvent.VK_T);
     	menu.add(menuItem);
     		
     	//// Setzen der Menüleiste
     	setJMenuBar(menuBar);

	}
	
	private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		//if (source == ) {
		//	System.out.println("neue Email");
		//}
		
	}
	
}

class AccFrame extends JFrame {
	
    public AccFrame() {
        setTitle("Acc Info");
        setSize(350, 400);
        centerWindow(this);
        setResizable(false);
        JPanel panel = new AccPanel();
        this.add(panel);
    }

    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
    }

}
class SendFrame extends JFrame {
	
    public SendFrame() {
        setTitle("Send Info");
        setSize(890, 600);
        centerWindow(this);
        setResizable(false);
        JPanel panel = new SendPanel();
        this.add(panel);
    }

    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
    }

}

class HauptPanel extends JPanel implements ActionListener {

    private JButton AccButton = new JButton("Acc");
    private JButton SendButton = new JButton("Senden");
    

    public HauptPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
   
              
// button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

// Acc button 
        
        AccButton.addActionListener(this);
        buttonPanel.add(AccButton);

// send button 
        
        SendButton.addActionListener(this);
        buttonPanel.add(SendButton);
        


// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.NORTH);

    }


    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
       
        if (source == AccButton) {
        	JFrame AccFrame = new AccFrame();
    	    AccFrame.setVisible(true);
            
        }
        if (source == SendButton) {
        	JFrame SendFrame = new SendFrame();
    	    SendFrame.setVisible(true);
            
        }
        
                      
    }
}
class AccPanel extends JPanel implements ActionListener {
	private JTextField emailAbsenderText, passwortText, sendServerText, recServerText, benutzerText, portText  ;
    private JLabel emailAbsenderLabel, passwortLabel, sendServerLable, recServerLable, benutzerLable, portLable;
    private JButton OKButton = new JButton("OK");
    
    

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
        passwortLabel.add(passwortText);
        
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
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
       
        if (source == OKButton) {
        	String sendServer = sendServerText.getText();
        	String recServer =  recServerText.getText();
        	String name = emailAbsenderText.getText();
        	String passwort = passwortText.getText();
        	
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
class SendPanel extends JPanel implements ActionListener {
	private JTextField emailEmpfaengerText,  subjectText ;
	private JTextArea textText;
    private JLabel emailEmpfaengerLabel, subjectLabel, textLabel ;
    private JButton SendButton = new JButton("Send");
    

    public SendPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Labels
      //EmailEmpfänger
        emailEmpfaengerLabel = new JLabel("Empfänger-Adressen(durch , getrennt:");
        displayPanel.add(emailEmpfaengerLabel);

        emailEmpfaengerText = new JTextField(80);
        displayPanel.add(emailEmpfaengerText);


        //Betreff
        subjectLabel = new JLabel("Betreff: ");
        displayPanel.add(subjectLabel);

        subjectText = new JTextField(80);
        displayPanel.add(subjectText);


        //Textkörper
        textLabel = new JLabel("Text: ");
        displayPanel.add(textLabel);

        textText = new JTextArea(30,75);
        displayPanel.add(textText);
        
        
        
   
              
// button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

// Send button 
        
        SendButton.addActionListener(this);
        buttonPanel.add(SendButton);

        


// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == SendButton) {
            String emailEmpfaenger = emailEmpfaengerText.getText();
            String subject =  subjectText.getText();
            String text = textText.getText();
            JOptionPane.showMessageDialog(null, "sendet");

            //ClientSend(sendServer, name,pw, port, emailEmpfaenger, subject, text); 
            //xx wie kann ich auf die Variablen aus der anderen Klasse zugreifen?
        }


    }

    public static void ClientSend(String server,String name,String pw,String port,String emailEmpfaenger,String subject, String messageText) {
        	try {

            int i=1,c=0;

            String[] rcpt = {emailEmpfaenger};

            boolean sessionDebug = false;


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
        }

    }


} // acc frame , send frame designed , password evtl noch zeichen ersetzen







