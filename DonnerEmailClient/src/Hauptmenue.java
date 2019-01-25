
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Hauptmenue {
	
	
	public static void main(String[] args) {
		JFrame frameMain = new FrameHaupt();
	    frameMain.setVisible(true);
	    
	}
}	
		
		/*Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame;
		frame = new JFrame("DonnerEmailClient"); frame.setSize(d);
		// Anzeigen des Frames
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        setSize(400, 800);
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

class HauptPanel extends JPanel implements ActionListener {

    private JButton AccButton = new JButton("Acc");
    

    public HauptPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
   
              
// button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

// Acc button 
        
        AccButton.addActionListener(this);
        buttonPanel.add(AccButton);

        


// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.NORTH);

    }


    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
       
        if (source == AccButton) {
        	JFrame frameAcc = new AccFrame();
    	    frameAcc.setVisible(true);
            
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
        
   
              
// button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

// Acc button 
        
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
        	//framePass.setVisible(true);
            
        }
        
                      
    }
}
    







