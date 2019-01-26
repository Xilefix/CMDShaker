import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HauptPanel extends JPanel implements ActionListener {

    private JButton AccButton = new JButton("Acc");
    private JButton SendButton = new JButton("Senden");
    

    public HauptPanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
   
              
// button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

// Acc button 
        
        AccButton.addActionListener(this);
        buttonPanel.add(AccButton);

// send button 
        
        SendButton.addActionListener(this);
        buttonPanel.add(SendButton);
        


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
        
                      
    }
}