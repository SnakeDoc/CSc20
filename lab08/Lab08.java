/**
 * Jason Sipula
 * CSc 20 M/W 2pm
 * Lab 08
 * Section 4
 */
 
import javax.swing.*;
import java.awt.*;

public class Lab08 {
	public static void main(String[] args) {
		new Lab08().run();
	}
	
	public void run() {
		JFrame frame = new JFrame("JCalc");
		frame.setLayout(new BorderLayout());
		frame.setSize(425, 190);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// top section
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		JLabel topLabel = new JLabel("                                     CSc 20 Lab 08       ");
		topLabel.setHorizontalTextPosition(JLabel.CENTER);
		JTextField textField = new JTextField("0.");
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		topPanel.add(topLabel, BorderLayout.CENTER);
		topPanel.add(textField, BorderLayout.SOUTH);
		
		// buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton buttonC = new JButton(" C ");
		buttonC.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(buttonC);
		
		JButton buttonCE = new JButton(" CE ");
		buttonCE.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(buttonCE);
		
		JButton buttonPlusMinus = new JButton(" +/- ");
		buttonPlusMinus.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(buttonPlusMinus);
		
		JButton buttonDivide = new JButton(" / ");
		buttonDivide.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(buttonDivide);
		
		JButton button7 = new JButton(" 7 ");
		button7.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button7);
		
		JButton button8 = new JButton(" 8 ");
		button8.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button8);
		
		JButton button9 = new JButton(" 9 ");
		button9.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button9);
		
		JButton buttonMultiply = new JButton(" * ");
		buttonMultiply.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(buttonMultiply);
		
		JButton button4 = new JButton(" 4 ");
		button4.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button4);
		
		JButton button5 = new JButton(" 5 ");
		button5.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button5);
		
		JButton button6 = new JButton(" 6 ");
		button6.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button6);
		
		JButton buttonMinus = new JButton(" - ");
		buttonMinus.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(buttonMinus);
		
		JButton button1 = new JButton(" 1 ");
		button1.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button1);
		
		JButton button2 = new JButton(" 2 ");
		button2.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button2);
		
		JButton button3 = new JButton(" 3 ");
		button3.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(button3);
		
		JButton buttonPlus = new JButton(" + ");
		buttonPlus.setPreferredSize(new Dimension(100, 25));
		buttonPanel.add(buttonPlus);
		
		// bottom buttons
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		JButton button0 = new JButton(" 0 ");
		button0.setPreferredSize(new Dimension(205, 25));
		bottomPanel.add(button0);
		
		JButton buttonPoint = new JButton(" . ");
		buttonPoint.setPreferredSize(new Dimension(100, 25));
		bottomPanel.add(buttonPoint);
		
		JButton buttonEquals = new JButton(" = ");
		buttonEquals.setPreferredSize(new Dimension(100, 25));
		bottomPanel.add(buttonEquals);
		
		// add all panes to frame
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}