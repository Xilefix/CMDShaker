
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
	//public static String sendServer;
	//public static String recServer;
	//public static String name;
	//public static String passwort;
	
	public static void main(String[] args) {
		

    	
    	
		
		
		JFrame MainFrame = new HauptFrame();
	    MainFrame.setVisible(true);
	    
	    
	    
	}

}
		


class HauptFrame extends JFrame implements ActionListener{
	public HauptFrame() {
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
     	final JMenuItem neueEMail= new JMenuItem("neue eMail", KeyEvent.VK_T);
     	menu.add(neueEMail);
     	
     	final JMenuItem Empfangen = new JMenuItem("Empfangen", KeyEvent.VK_T);
     	menu.add(Empfangen);
     	
     	final JMenuItem Optionen = new JMenuItem("Optionen", KeyEvent.VK_T);
     	menu.add(Optionen);
     	
     	final JMenuItem Beenden = new JMenuItem("Beenden", KeyEvent.VK_T);
     	menu.add(Beenden);
     	
     	
     	
     	
     	//// Setzen der Menüleiste
     	setJMenuBar(menuBar);

     	class Aktion implements ActionListener{
     	public void actionPerformed(ActionEvent e) {
    		Object source = e.getSource();
    		
    		if (source == neueEMail) {
    			JFrame SendFrame = new SendFrame();
        	    SendFrame.setVisible(true);
    		}
    		if (source == Empfangen) {
    			JOptionPane.showMessageDialog(null, "Empfangen.");
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







