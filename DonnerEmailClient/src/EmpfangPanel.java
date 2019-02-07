import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.mail.util.MailSSLSocketFactory;


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
    private JList emailList;
    //private String[] listArray = {};
    
   
    private String[] splitByNumber(String s, int chunkSize){                                //Quelle: https://stackoverflow.com/questions/9276639/java-how-to-split-a-string-by-a-number-of-characters
        int chunkCount = (s.length() / chunkSize) + (s.length() % chunkSize == 0 ? 0 : 1);
        String[] returnVal = new String[chunkCount];
        for(int i=0;i<chunkCount;i++){
            returnVal[i] = s.substring(i*chunkSize, Math.min((i+1)*chunkSize-1, s.length()));
        }
        return returnVal;
    }
    
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
        displayPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
      
        
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
        	String[] listArray = new String[line.length]; //Betreff absender und date
        	String[] listArray1 = new String[line.length]; //email
			for(int c=0; c<line.length;c++) {
				
				String[] a = line[c].split(",-,");		//0 betreff 1 adresse 2 date 3 inhalt
				for(int i=0;i<4;i++) 
					mails[c][i]=a[i];
				
			}
			
        	for(int c =0; c<line.length;c++) {
        		
        		listArray[c] = "Betreff: "+ mails[c][0] +"Absender: "+ mails[c][1] + "Datum: "+mails[c][2];
        		listArray1[c] = "Betreff: "+mails[c][0] + "\n"+ "Absender: "+ mails[c][1] + "\n" + "Datum: "+mails[c][2]+ "\n" + "Text: "+mails[c][3];
        		
        		
                
             
        		
        		/*
        		subjectText = new JTextField(80);
        		subjectText.setText("Betreff: "+mails[c][0]);
                displayPanel.add(subjectText);
                subjectText.setEditable(false);
                subjectText.setHorizontalAlignment(JTextField.LEFT);
                subjectText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
                
                emailSenderText = new JTextField(80);
                emailSenderText.setText("Absender: "+ mails[c][1]);
                displayPanel.add(emailSenderText);
                emailSenderText.setEditable(false);
                emailSenderText.setHorizontalAlignment(JTextField.LEFT);
                emailSenderText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
                
                datumText = new JTextField(80);
                datumText.setText("Datum: "+mails[c][2]);
                displayPanel.add(datumText);
                datumText.setEditable(false);
                datumText.setHorizontalAlignment(JTextField.LEFT);
                datumText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
                
                
                textText = new JTextArea(25,75);
                textText.setText("Text: "+mails[c][3]); 
                textText.setLineWrap(true); //https://stackoverflow.com/questions/6410338/set-the-last-word-of-the-line-to-the-next-line-in-jtextarea
                textText.setWrapStyleWord(true);
                displayPanel.add(textText);
                textText.setEditable(false);                
                textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr)); 
                */
        		/*textText = new JTextArea(5,75);
        		textText.setText("Betreff: "+mails[c][0] + "\n"+ "Absender: "+ mails[c][1] + "\n" + "Datum: "+mails[c][2]+ "\n" + "Text: "+mails[c][3]);
        		textText.setLineWrap(true); //https://stackoverflow.com/questions/6410338/set-the-last-word-of-the-line-to-the-next-line-in-jtextarea
                textText.setWrapStyleWord(true);
                JScrollPane scroll = new JScrollPane(textText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                
                textText.setEditable(false);                
                textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr)); 
                displayPanel.add(scroll);*/
        	}
        	emailList = new JList(listArray); //https://www.youtube.com/watch?v=aLkkYbHz16E&index=71&list=PLFE2CE09D83EE3E28
            emailList.setVisibleRowCount(30);
            emailList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            emailList.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr)); 
            displayPanel.add(new JScrollPane(emailList));
            emailList.addListSelectionListener(
            		new ListSelectionListener() {
            			
    					public void valueChanged(ListSelectionEvent event) {
    						JFrame EMail = new JFrame();
    						EMail.setTitle("Emails");
    						EMail.setSize(1230, 750);
    						EMail.setResizable(false);
    						
    						//Toolkit tk = Toolkit.getDefaultToolkit();
    						//Dimension d = tk.getScreenSize();
					        //setLocation((d.width - EMail.getWidth()) / 2, (d.height - EMail.getHeight()) / 2);
					        EMail.setVisible(true);
					        JPanel displayPanel = new JPanel();
					        displayPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
					        textText = new JTextArea(25,75);
					        textText.setText(listArray1[emailList.getSelectedIndex()]);
					        textText.setLineWrap(true); //https://stackoverflow.com/questions/6410338/set-the-last-word-of-the-line-to-the-next-line-in-jtextarea
			                textText.setWrapStyleWord(true);
			            	textText.setEditable(false);                
			                textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr)); 
			                displayPanel.add(textText);
					        
					        EMail.setLayout(new BorderLayout());
					        EMail.add(displayPanel, BorderLayout.CENTER);
					        
    						
    						
    						
    						
    					}
    				});
        	
        	
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


