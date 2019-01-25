
import java.awt.*;
import java.awt.event.*;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Hauptmenue {






	public static void main(String[] args) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
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
		
		
		//passwort frame
		JFrame framePass;
		framePass = new JFrame("Acc Info"); 
		framePass.setSize(1000,800);
		
		
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




}

