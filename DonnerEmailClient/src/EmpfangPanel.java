import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 *  public class EmpfangPanel extends JPanel {
 
	
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
        datumLabel = new JLabel("Datum: ");
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
}*/

public class EmpfangPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Schriftgr��e und Art
    String Schriftyp ="Calibri"; 
 	int Schriftgr = 20; //x
	
 	//Variablen
	private JTextField emailSenderText, subjectText, datumText;
	private JTextArea textText;
    private JLabel emailSenderLabel, subjectLabel, datumLabel, textLabel;
    public String emailEmpfaenger, subject, text;
    
    public String mailinhaltAlsEinzeiler(String dateipfad) throws IOException
    {
       FileReader reader = new FileReader(dateipfad);
       BufferedReader inBuffer = new BufferedReader(reader);
       
       String line="\"";
       while(inBuffer.read()!=-1) {
    	   line = line+inBuffer.readLine();
       }
       line=line+"";
       inBuffer.close();
       return line;
    }
    
    public EmpfangPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Labels



        //Betreff
        /*
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
        datumLabel = new JLabel("Datum: ");
        displayPanel.add(datumLabel);
        datumLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
        datumText = new JTextField(80);
        datumText.setText("Felix#jena1");
        datumText.setEditable(false);
        datumText.setHorizontalAlignment(JTextField.CENTER);
        displayPanel.add(datumText);
        datumText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        
      //Textk�rper
        textLabel = new JLabel("Text: ");
        displayPanel.add(textLabel);
        textLabel.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        textText = new JTextArea(25,75);
        */
        try {
        	

        	String[] line = mailinhaltAlsEinzeiler("C:\\Users\\Public\\mailAll.txt").split(";-;");
        	String mails[][]=new String[line.length][4];
        	
			for(int c=0; c<line.length;c++) {
				
				String[] a = line[c].split(",-,");		//0 betreff 1 adresse 2 date 3 inhalt
				for(int i=0;i<4;i++) 
					mails[c][i]=a[i];
				
			}
        	for(int c =0; c<line.length;c++) {
        		subjectText = new JTextField("Betreff: "+mails[c][0]);
                displayPanel.add(subjectText);
                subjectText.setEditable(false);
                subjectText.setHorizontalAlignment(JTextField.LEFT);
                subjectText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
                
                emailSenderText = new JTextField("Absender: "+ mails[c][1]);
                displayPanel.add(emailSenderText);
                emailSenderText.setEditable(false);
                emailSenderText.setHorizontalAlignment(JTextField.LEFT);
                emailSenderText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
                
                datumText = new JTextField("Datum: "+mails[c][2]);
                displayPanel.add(datumText);
                datumText.setEditable(false);
                datumText.setHorizontalAlignment(JTextField.LEFT);
                datumText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

                textText = new JTextArea(25,75);
                textText.setText("Text: "+mails[c][3]);
                displayPanel.add(textText);
                textText.setEditable(false);
                //subjectText.setHorizontalAlignment(JTextArea.WEST);
                textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        	}
        	
        	
        	//textText.setText(mailinhaltAlsEinzeiler("C:\\Users\\Public\\mailAll.txt"));
			
			
			//System.out.println(mailinhaltAlsEinzeiler("C:\\Users\\Public\\mailAll.txt"));
			//System.out.println(mails[1][1]);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //textText.setEditable(false);
        //displayPanel.add(textText);
        //textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));

        


        // add panels zum HauptPanel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);


    }
}


