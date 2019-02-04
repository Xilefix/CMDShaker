import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmpfangPanel extends JPanel {
	//Schriftgröße und Art
    String Schriftyp ="Calibri"; 
 	int Schriftgr = 20; //x
	
 	//Variablen
	private JTextField emailEmpfaengerText,  subjectText ;
	private JTextArea textText;
    private JLabel emailEmpfaengerLabel, subjectLabel, textLabel ;
    public String emailEmpfaenger, subject, text;
    
    
    
    public EmpfangPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Labels



        //Betreff
        subjectLabel = new JLabel("Betreff: \n Absender: \n\n");
        displayPanel.add(subjectLabel);
        subjectLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));


        

        


// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);





    }
}