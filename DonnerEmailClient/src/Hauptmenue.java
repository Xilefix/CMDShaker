
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Hauptmenue {
	
	
	public static void main(String[] args) {
		JFrame MainFrame = new FrameHaupt();
	    MainFrame.setVisible(true);
	    
	}
}	
		
		/*
		// Erzeugen des File-Menüs
		Menu fileMenu = new Menu("File");
		fileMenu.add("neue eMail");
		fileMenu.add("Empfangen");
		fileMenu.add("Optionen");
		fileMenu.add("Beenden");

		//Button Acc
		Button Acc = new Button("Acc");
		frame.setLayout(new FlowLayout());
		frame.add(Acc);
		
		
		//Frame für passwort 
		JFrame framePass;
		framePass = new JFrame("Acc Info"); 
		framePass.setSize(1000,800);
		TextField hello = new TextField("Hello", 1);
		framePass.add(hello);
		
		
		//action
		Acc.addActionListener(new ActionListener(){	public void actionPerformed(ActionEvent e) {
			if ("Acc".equals(e.getActionCommand()));
			framePass.setVisible(true);
				

		}});
		Acc.setActionCommand("Acc");



		// Erzeugen der Menüleiste und Hinzufügen der Menüs
		MenuBar myMenuBar = new MenuBar();
		myMenuBar.add(fileMenu);
		// Setzen der Menüleiste
		frame.setMenuBar(myMenuBar);




		}
	//acc button

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	*/


class FrameHaupt extends JFrame {
	public FrameHaupt() {
		setTitle("DonnerEmailClient");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(d);
		centerWindow(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new HauptPanel();
        this.add(panel);
	}
	
	private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
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
        setSize(550, 500);
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
        //final JPasswordField passwortText = new JPasswordField(30);
        displayPanel.add(passwortText);
        
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
        	String pw = passwortText.getText();
        	//String pw = new String(((JPasswordField) passwortText).getPassword()); 
        	//http://www.zentut.com/java-swing/creating-password-field-by-using-jpasswordfield-class/
        	String port = portText.getText();
        	
            
        }
        
                      
    }
    
}
class SendPanel extends JPanel implements ActionListener {
	private JTextField emailEmpfaengerText,  subjectText, textText;
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

        textText = new JTextField(1000);
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
        	System.out.println(emailEmpfaengerText);
        	
            
        }
        
                      
    }
} // acc frame , send frame designed , password evtl noch zeichen ersetzen







