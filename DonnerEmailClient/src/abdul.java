
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class abdul {

    public static void main(String[] args) {
        JFrame frame = new FutureValueFrame();
        frame.setVisible(true);
    }
}

class FutureValueFrame extends JFrame {

    public FutureValueFrame() {
        setTitle("Acc Info");
        setSize(1000, 800);
        centerWindow(this);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new FutureValuePanel();
        this.add(panel);
    }

    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
    }
}

class FutureValuePanel extends JPanel implements ActionListener {

    private JTextField paymentText, rateText, yearsText, loanText;
    private JLabel paymentLabel, rateLabel, yearsLabel, loanLabel;
    private JButton calculateButton, exitButton, paymentButton, loanButton;
    private int counter = 0;

    public FutureValuePanel() { // display panel 
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));


        loanLabel = new JLabel("Loan Amount:");
        displayPanel.add(loanLabel);
        //hello
        loanText = new JTextField(10);
        displayPanel.add(loanText);

        //////



        ///////
        rateLabel = new JLabel("Yearly Interest Rate:");
        displayPanel.add(rateLabel);

        rateText = new JTextField(10);
        displayPanel.add(rateText);


////////
        yearsLabel = new JLabel("Number of Years:");
        displayPanel.add(yearsLabel);

        yearsText = new JTextField(10);
        displayPanel.add(yearsText);



////////
        paymentLabel = new JLabel("Monthly Payment:");
        displayPanel.add(paymentLabel);
        //hello
        paymentText = new JTextField(10);
        displayPanel.add(paymentText);


// button panel
        JPanel buttonPanel = new JPanel();
        JPanel alphaPanel = new JPanel();
        ;
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        alphaPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

// calculate button 
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        buttonPanel.add(calculateButton);

        paymentButton = new JButton("Monthly Payment");
        paymentButton.addActionListener(this);
        alphaPanel.add(paymentButton);


        loanButton = new JButton("Loan Amount");
        loanButton.addActionListener(this);
        alphaPanel.add(loanButton);


// exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);
// add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(alphaPanel, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == exitButton) {
            System.exit(0);
        }


        if (source == loanButton) {
            loanText.setEditable(false);
            loanText.setFocusable(false);
            loanText.setText(null);
            paymentText.setEditable(true);
            paymentText.setFocusable(true);
            counter = 1;
        }
        if (source == paymentButton) {
            paymentText.setEditable(false);
            paymentText.setFocusable(false);
            paymentText.setText(null);
            loanText.setEditable(true);
            loanText.setFocusable(true);
            counter = 2;
        }
        if (source == calculateButton) {
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            //  paymentText.setText(currency.format(Double.parseDouble(loanText.getText())));
            //  
            //          paymentText.setText(the);
            //loanText.setText(" ");
            //  paymentText.setText(" ");

            if (counter == 1) {
                Double rate = Double.parseDouble(rateText.getText());
                Double years = Double.parseDouble(yearsText.getText());
                Double payment = Double.parseDouble(paymentText.getText());
                String result = currency.format(((1 - (1 / (Math.pow((1 + (rate / 12)), (years * 12))))) * payment * 12) / rate);
                loanText.setText(result.substring(1));
            }

            if (counter == 2) {

                Double loan = Double.parseDouble(loanText.getText());
                Double rate = Double.parseDouble(rateText.getText());
                Double years = Double.parseDouble(yearsText.getText());
                String retur = currency.format(((loan * (rate / 12)) / (1 - (1 / (Math.pow((1 + (rate / 12)), (years * 12)))))));
                paymentText.setText(retur.substring(1));
            }
        }
    }
}