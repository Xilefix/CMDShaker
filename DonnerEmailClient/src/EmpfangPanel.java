import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class EmpfangPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	//Schriftgroesse und Art
    String Schriftyp ="Calibri"; 
 	int Schriftgr = 20; 
 	
	
 	//Variablen
	private JTextArea textText;
    public String emailEmpfaenger, subject, text;
    private JList<Object> emailList;
    //private String[] listArray = {};
    
   
    
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
    
    
      
        
       
     
        
       /* try {
        	
        	
        	
        	String[] line = mailinhaltAlsEinzeiler("C:\\Users\\Public\\mailAll.txt").split(";-;"); //windows
        	//String[] line = mailinhaltAlsEinzeiler("C:\\Users\\Public\\mailAll.txt").split(";-;");//linux
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
        		
        		
                
             
        		
        		
        	}
        	emailList = new JList<Object>(listArray); //https://www.youtube.com/watch?v=aLkkYbHz16E&index=71&list=PLFE2CE09D83EE3E28
            emailList.setVisibleRowCount(30);
            emailList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            emailList.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr)); 
            displayPanel.add(new JScrollPane(emailList));
            emailList.addListSelectionListener(
            		new ListSelectionListener() {
            			
    					public void valueChanged(ListSelectionEvent event) {
    						JFrame EMail = new JFrame("Emails");
    						EMail.setSize(1230, 750);
    						Toolkit tk = Toolkit.getDefaultToolkit();
    						Dimension d = tk.getScreenSize();
					        EMail.setLocation((d.width - EMail.getWidth()) / 2, (d.height - EMail.getHeight()) / 2);
					        EMail.setResizable(false);					        
					        JPanel displayPanel1 = new JPanel();
					        displayPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));//zweimal
					        textText = new JTextArea(25,75);
					        textText.setText(listArray1[emailList.getSelectedIndex()]);
					        textText.setLineWrap(true); //https://stackoverflow.com/questions/6410338/set-the-last-word-of-the-line-to-the-next-line-in-jtextarea
			                textText.setWrapStyleWord(true);
			            	textText.setEditable(false);                
			                textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr)); 
			                displayPanel1.add(textText);
			                EMail.add(displayPanel1);
					        
			                //EMail.setLayout(new BorderLayout());
					        EMail.add(displayPanel1, BorderLayout.CENTER);
					        //System.out.println("hallo");// alles ist zweimal mit der Maus meistens manchmal nicht wieso??
					        EMail.setVisible(true);
    						
    						
    						
    					}
    				});
        	
        	
        	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        


        // add panels zum HauptPanel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);


    }*/



public EmpfangPanel() { // display panel
    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

    boolean checkFile = new File("C:\\Users\\Public\\mailAll.txt").isFile();
    	if(checkFile) {
    try {
    	//System.out.println(mailinhaltAlsEinzeiler("C:\\Users\\Public\\mailAll.txt"));
        String[] line =
        mailinhaltAlsEinzeiler("C:\\Users\\Public\\mailAll.txt").split(";-;");
        String mails[][]=new String[line.length][4];
        String[] listArray = new String[line.length]; //Betreff absender und date
        String[] listArray1 = new String[line.length]; //email
        for(int c=0; c<line.length;c++) {

            String[] a = line[c].split(",-,");        //0 betreff 1 adresse 2 date 3 inhalt
            for(int i=0;i<4;i++)
            	mails[c][i]=a[i];

        }

        for(int c =0; c<line.length;c++) {

            listArray[c] = "Betreff: "+ mails[c][0] +"Absender: "+ mails[c][1] + "Datum: "+mails[c][2];
            listArray1[c] = "Betreff: "+mails[c][0] + "\n"+"Absender: "+ mails[c][1] + "\n" + "Datum: "+mails[c][2]+ "\n" + "Text: "+mails[c][3];



        }
        emailList = new JList(listArray);
//https://www.youtube.com/watch?v=aLkkYbHz16E&index=71&list=PLFE2CE09D83EE3E28
        emailList.setVisibleRowCount(30); emailList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        emailList.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        displayPanel.add(new JScrollPane(emailList));
        emailList.addListSelectionListener(
                new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent event) {
                        JFrame EMail = new JFrame();
                        EMail.setTitle("Emails");
                        EMail.setSize(1230, 750);
                        Toolkit tk = Toolkit.getDefaultToolkit();
						Dimension d = tk.getScreenSize();
				        EMail.setLocation((d.width - EMail.getWidth()) / 2, (d.height - EMail.getHeight()) / 2);
                        EMail.setResizable(false);

                        EMail.setVisible(true);
                        JPanel displayPanel = new JPanel();
                        displayPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
                        textText = new JTextArea(25,75);
                        textText.setText(listArray1[emailList.getSelectedIndex()]);
                        textText.setLineWrap(true); //https://stackoverflow.com/questions/6410338/set-the-last-word-of-the-line-to-the-next-line-in-jtextarea
                        textText.setWrapStyleWord(true); textText.setEditable(false);
                        textText.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
                        displayPanel.add(textText);

                        EMail.setLayout(new BorderLayout());
                        EMail.add(displayPanel, BorderLayout.CENTER);

                    }
                });

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    // add panels zum HauptPanel
    this.setLayout(new BorderLayout());
    this.add(displayPanel, BorderLayout.CENTER);


	}
}

