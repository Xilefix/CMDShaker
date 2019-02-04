import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmpfangPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Schriftgröße und Art
    String Schriftyp ="Calibri"; 
 	int Schriftgr = 20; //x
	
 	//Variablen
	private JTextField emailSenderText, subjectText, datumText;
	private JTextArea textText;
    private JLabel emailSenderLabel, subjectLabel, datumLabel, textLabel;
    public String emailEmpfaenger, subject, text;
    
    
    
    public EmpfangPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Labels



        //Betreff
        subjectLabel = new JLabel("Betreff: ");
        displayPanel.add(subjectLabel);
        subjectLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        subjectText = new JTextField(80);
        subjectText.setText("Felix#jena1");
        subjectText.setEditable(false);
        subjectText.setHorizontalAlignment(JTextField.CENTER);
        displayPanel.add(subjectText);
        subjectText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        //Absender
        emailSenderLabel = new JLabel("Absender: ");
        displayPanel.add(emailSenderLabel);
        emailSenderLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        emailSenderText = new JTextField(80);
        emailSenderText.setText("Felix#jena1");
        emailSenderText.setEditable(false);
        emailSenderText.setHorizontalAlignment(JTextField.CENTER);
        displayPanel.add(emailSenderText);
        emailSenderText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        //Datum
        datumLabel = new JLabel("Betreff: ");
        displayPanel.add(datumLabel);
        datumLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        datumText = new JTextField(80);
        datumText.setText("Felix#jena1");
        datumText.setEditable(false);
        datumText.setHorizontalAlignment(JTextField.CENTER);
        displayPanel.add(datumText);
        datumText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
      //Textkörper
        textLabel = new JLabel("Text: ");
        displayPanel.add(textLabel);
        textLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        textText = new JTextArea(25,75);
        textText.setText("Felix#jena1");
        textText.setEditable(false);
        displayPanel.add(textText);
        textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        


// add panels zum HauptPanel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);





    }
}