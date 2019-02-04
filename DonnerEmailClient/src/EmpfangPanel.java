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