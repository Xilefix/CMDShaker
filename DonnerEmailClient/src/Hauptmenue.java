import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.mail.*;
import java.util.Properties;

public class Hauptmenue{
	
	public static void main(String[] args) {
	JFrame MainFrame = new HauptFrame();
	MainFrame.setVisible(true);
	    
	    
	    
	}


}	


class HauptFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HauptFrame() {
		setTitle("DonnerEmailClient");
		setSize(550, 250);//x
		centerWindow(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new HauptPanel();
        this.add(panel);
        
        

        
        //Schriftgröße und Art
        String Schriftyp ="Calibri"; 
     	int Schriftgr = 20; //x
        
        // Erzeugen der Menüleiste und Hinzufügen der Menüs
        JMenuBar menuBar;
        JMenu menu;
        //JMenuItem menuItem;
        menuBar = new JMenuBar();
     	menu = new JMenu("File");
     	
     	menu.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
     	
     	menu.setMnemonic(KeyEvent.VK_A);
     	menu.getAccessibleContext().setAccessibleDescription("Filemenue");
     	menu.setPreferredSize(new Dimension(50,40));//x
     	
     	
     	menuBar.add(menu);
     		
     	//JMenuItems
     	final JMenuItem neueEMail= new JMenuItem("neue eMail", KeyEvent.VK_T);
     	menu.add(neueEMail);
     	
     	final JMenuItem Empfangen = new JMenuItem("Empfangen", KeyEvent.VK_T);
     	menu.add(Empfangen);
     	
     	final JMenuItem Optionen = new JMenuItem("Optionen", KeyEvent.VK_T);
     	menu.add(Optionen);
     	
     	final JMenuItem Beenden = new JMenuItem("Beenden", KeyEvent.VK_T);
     	menu.add(Beenden);
     	
     	//Filemenuitem größe
     	neueEMail.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
     	Empfangen.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
     	Optionen.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));
     	Beenden.setFont(new Font(Schriftyp, Font.BOLD, Schriftgr));//x
     	
     	
     	
     	//// Setzen der Menüleiste
     	setJMenuBar(menuBar);
     	

     	class Aktion implements ActionListener{
     		//Empfangen Emails
     		public void mailAbholen(String server,String name, String pw) {
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
     					//Integer num= i+1;
     					mails[i][0]=message.getSubject();						//betreff 0
     					//mails[i][1]=num.toString();								//EMail Nummer 1 message ID https://stackoverflow.com/questions/3939051/message-id-in-a-pop3-protocol ganz unten
     					mails[i][1]=message.getFrom()[0].toString();			//abs 1
     					mails[i][2]=message.getSentDate().toString();			//date 2
     					if ( message.isMimeType( "text/plain" ) ) {				//inhalt 3
     						mails[i][3]=message.getContent().toString();
     					}
     					message.setFlag(Flags.Flag.DELETED, true);			//x
     				}




     				try {
     	                boolean checkFile = new File("C:\\Users\\Public\\mailAll.txt").isFile();//windows
     	               //boolean checkFile = new File("C:\\Users\\Public\\mailAll.txt").isFile();//linux

     	                BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Public\\mailAll.txt", true));//windows
     	               //BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Public\\mailAll.txt", true));//linux
     	                if(checkFile) {
     	                    writer1.write(";-;");
     	                }
     	                for (int i = 0; i < mails.length; i++) {
     	                    for (int j = 0; j < mails[i].length; j++) {
     	                        writer1.write("\""+ mails[i][j]+ "\"");
     	                        if(j<mails[i].length-1) {writer1.write(",-,");}
     	                    }
     	                    if(i<mails.length-1) {writer1.write(";-;");}
     	                    //writer.newLine(); // <-----------------
     	                }
     	                writer1.close();;
     	            }
     	            catch (IOException e) {
     	            e.printStackTrace();
     	            }//z
     				JOptionPane.showMessageDialog(null, "Sie haben "+mails.length+" neue Emails im Postfach.");


     				emailFolder.close(true);
     				emailStore.close();
     			}catch(NoSuchProviderException nspe) {
     				nspe.printStackTrace();
     			}catch(MessagingException me) {
     				me.printStackTrace();
     			}catch(IOException ioe) {
     				ioe.printStackTrace();
     			}

     		}
     	public void actionPerformed(ActionEvent e) {
    		Object source = e.getSource();
    		
    		if (source == neueEMail) {
    			JFrame SendFrame = new SendFrame();
        	    SendFrame.setVisible(true);
    		}
    		if (source == Empfangen) {
    			try {
                    BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Public\\acc.txt"));//windows
                    //BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Public\\acc.txt"));//linux
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
    		if (source == Optionen) {
    			JOptionPane.showMessageDialog(null, "Optionen.");
    		}
    		if (source == Beenden) {
    			
    			System.exit(0);
    		}
    		
    		
    	}
     	}
     	neueEMail.addActionListener(new Aktion());
     	Empfangen.addActionListener(new Aktion());
     	Optionen.addActionListener(new Aktion());
     	Beenden.addActionListener(new Aktion());
	}
	
	private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

class AccFrame extends JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccFrame() {
        setTitle("Acc Info");
        setSize(550, 700);//x
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
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SendFrame() {
        setTitle("Send Info");
        setSize(1300, 1000);//x
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
class EmpfangFrame extends JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpfangFrame() {
        setTitle("Emails");
        //setSize(1300, 1000);//x
        setSize(900, 600);
        centerWindow(this);
        setResizable(false);        
        JPanel panel = new EmpfangPanel();
        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
        //this.add(panel);
    }

    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
    }

}






