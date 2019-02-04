import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.swing.JOptionPane;

public class HauptPanel extends JPanel implements ActionListener {
	//Schriftgröße und Art
    String Schriftyp ="Calibri"; 
 	int Schriftgr = 20; //x
	
	
	//Buttons
    private JButton AccButton = new JButton("Account");
    private JButton SendButton = new JButton("Senden");
    private JButton EmailsEmpfangen = new JButton("Empfangen");
    
    
    //Empfangen Emails
	public static void mailAbholen(String server,String name, String pw) {
		try {
			Properties props = new Properties();
			props.setProperty("mail.store.protocol","pop3");
			Session emailSession = Session.getDefaultInstance(props);
			Store emailStore = emailSession.getStore("pop3");
			emailStore.connect(server,name,pw);
			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
			Message messages[] = emailFolder.getMessages();



			String[][] mails = new String[messages.length][4];			//initialisiert 2D-array
			for(int i=0;i<messages.length;i++) {					  	//Schleife speichert Mails in 2D-Array/Datei
				Message message =messages[i];
				Integer num= i+1;
				mails[i][0]=message.getSubject();						//betreff 0
				//mails[i][1]=num.toString();								//EMail Nummer 1 message ID https://stackoverflow.com/questions/3939051/message-id-in-a-pop3-protocol ganz unten
				mails[i][1]=message.getFrom()[0].toString();			//abs 1
				mails[i][2]=message.getSentDate().toString();			//date 2
				if ( message.isMimeType( "text/plain" ) ) {				//inhalt 3
					mails[i][3]=message.getContent().toString();
				}
				//message.setFlag(Flags.Flag.DELETED, true);			//x
			}

			//BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Public\\mailBU.txt"));
        	//String mail = read.readLine();


			File mailBU=new File("C:\\Users\\Public\\mailBU.txt");
			try {
			    BufferedWriter writer = new BufferedWriter(new FileWriter(mailBU));
			    //writer.write(mail);
			    writer.write("{");
				for (int i = 0; i < mails.length; i++) {
					writer.write("{");
					for (int j = 0; j < mails[i].length; j++) {
						writer.write("\""+ mails[i][j]+ "\"");
						if(j<mails[i].length-1) {writer.write(",");}
					}
					writer.write("}");
					if(i<mails.length-1) {writer.write(",");}
					//writer.newLine(); // <-----------------
				}
				writer.write("}");
				writer.close();
			}
			catch (IOException e) {
			e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Sie haben "+mails.length+" neue Emails im Postfach.");


			emailFolder.close(false);
			emailStore.close();
		}catch(NoSuchProviderException nspe) {
			nspe.printStackTrace();
		}catch(MessagingException me) {
			me.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}

	}

    public HauptPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
   
              
// button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

// Acc button 
        
        AccButton.addActionListener(this);
        AccButton.setPreferredSize(new Dimension(150,150));
        AccButton.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        buttonPanel.add(AccButton);
        

// send button 
        
        SendButton.addActionListener(this);
        SendButton.setPreferredSize(new Dimension(150,150));
        SendButton.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        buttonPanel.add(SendButton);
        
// Empfangen button 
        
        EmailsEmpfangen.addActionListener(this);
        EmailsEmpfangen.setPreferredSize(new Dimension(150,150));
        EmailsEmpfangen.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
        buttonPanel.add(EmailsEmpfangen);
        


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
        
        if (source == EmailsEmpfangen) {
        	try {
                BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Public\\acc.txt"));
                String in = read.readLine();

                String[] line = in.split(";");
                String server=line[0];
                String name = line[2];
                String pw=line[3];
                //String port=line[5];
                read.close();
                mailAbholen(server,name,pw);

            } catch (FileNotFoundException f) {
                // TODO Auto-generated catch block
                f.printStackTrace();
            } catch (IOException f) {
                // TODO Auto-generated catch block
                f.printStackTrace();
            }
        	JFrame RecFrame = new EmpfangFrame();
        	RecFrame.setVisible(true);
        }
        
        
                      
    }
}