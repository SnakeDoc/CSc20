/**
 * Jason Sipula
 * CSc 20 M/W 2pm
 * Lab 09
 * Section 1
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab09 implements ActionListener {
	
	Double operand1;
	Double operand2;
	Double res;
	
	JButton buttonC;
	JButton buttonCE;
	JButton buttonPlusMinus;
	JButton buttonDivide;
	JButton buttonMultiply;
	JButton buttonMinus;
	JButton buttonPlus;
	JButton buttonPoint;
	JButton buttonEquals;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	
	static JTextField textField = new JTextField("0.");
	
	boolean newNumber;
	char operator;

	public static void main(String[] args) {
		new Lab09().run();
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
		
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		topPanel.add(topLabel, BorderLayout.CENTER);
		topPanel.add(textField, BorderLayout.SOUTH);
		
		// buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		buttonC = new JButton(" C ");
		buttonC.setPreferredSize(new Dimension(100, 25));
		buttonC.addActionListener(this);
		buttonPanel.add(buttonC);
		
		buttonCE = new JButton(" CE ");
		buttonCE.setPreferredSize(new Dimension(100, 25));
		buttonCE.addActionListener(this);
		buttonPanel.add(buttonCE);
		
		buttonPlusMinus = new JButton(" +/- ");
		buttonPlusMinus.setPreferredSize(new Dimension(100, 25));
		buttonPlusMinus.addActionListener(this);
		buttonPanel.add(buttonPlusMinus);
		
		buttonDivide = new JButton(" / ");
		buttonDivide.setPreferredSize(new Dimension(100, 25));
		buttonDivide.addActionListener(this);
		buttonPanel.add(buttonDivide);
		
		button7 = new JButton(" 7 ");
		button7.setPreferredSize(new Dimension(100, 25));
		button7.addActionListener(this);
		buttonPanel.add(button7);
		
		button8 = new JButton(" 8 ");
		button8.setPreferredSize(new Dimension(100, 25));
		button8.addActionListener(this);
		buttonPanel.add(button8);
		
		button9 = new JButton(" 9 ");
		button9.setPreferredSize(new Dimension(100, 25));
		button9.addActionListener(this);
		buttonPanel.add(button9);
		
		buttonMultiply = new JButton(" * ");
		buttonMultiply.setPreferredSize(new Dimension(100, 25));
		buttonMultiply.addActionListener(this);
		buttonPanel.add(buttonMultiply);
		
		button4 = new JButton(" 4 ");
		button4.setPreferredSize(new Dimension(100, 25));
		button4.addActionListener(this);
		buttonPanel.add(button4);
		
		button5 = new JButton(" 5 ");
		button5.setPreferredSize(new Dimension(100, 25));
		button5.addActionListener(this);
		buttonPanel.add(button5);
		
		button6 = new JButton(" 6 ");
		button6.setPreferredSize(new Dimension(100, 25));
		button6.addActionListener(this);
		buttonPanel.add(button6);
		
		buttonMinus = new JButton(" - ");
		buttonMinus.setPreferredSize(new Dimension(100, 25));
		buttonMinus.addActionListener(this);
		buttonPanel.add(buttonMinus);
		
		button1 = new JButton(" 1 ");
		button1.setPreferredSize(new Dimension(100, 25));
		button1.addActionListener(this);
		buttonPanel.add(button1);
		
		button2 = new JButton(" 2 ");
		button2.setPreferredSize(new Dimension(100, 25));
		button2.addActionListener(this);
		buttonPanel.add(button2);
		
		button3 = new JButton(" 3 ");
		button3.setPreferredSize(new Dimension(100, 25));
		button3.addActionListener(this);
		buttonPanel.add(button3);
		
		buttonPlus = new JButton(" + ");
		buttonPlus.setPreferredSize(new Dimension(100, 25));
		buttonPlus.addActionListener(this);
		buttonPanel.add(buttonPlus);
		
		// bottom buttons
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		button0 = new JButton(" 0 ");
		button0.setPreferredSize(new Dimension(205, 25));
		button0.addActionListener(this);
		bottomPanel.add(button0);
		
		buttonPoint = new JButton(" . ");
		buttonPoint.setPreferredSize(new Dimension(100, 25));
		buttonPoint.addActionListener(this);
		bottomPanel.add(buttonPoint);
		
		buttonEquals = new JButton(" = ");
		buttonEquals.setPreferredSize(new Dimension(100, 25));
		buttonEquals.addActionListener(this);
		bottomPanel.add(buttonEquals);
		
		// add all panes to frame
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void addDigit(final int num) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (textField.getText().equals("0.")) {
					textField.setText(new Integer(num).toString());
				} else {
					textField.setText(textField.getText() + num);
				}
			}
		});
	}
	
	public static void display(final String disp) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				textField.setText(disp);
			}
		});
	}
	
	@Override
	public void actionPerformed(final ActionEvent e) {
	System.out.println("Op1: " + operand1 + " | Op2: " + operand2);
	
		if (newNumber) {
			display("");
			newNumber = false;
		}
	
		if (e.getSource() == button0) {
				addDigit(0); return;
		} else if (e.getSource() == button1) {
				addDigit(1); return;
		} else if (e.getSource() == button2) {
				addDigit(2); return;
		} else if (e.getSource() == button3) {
				addDigit(3); return;
		} else if (e.getSource() == button4) {
				addDigit(4); return;
		} else if (e.getSource() == button5) {
				addDigit(5); return;
		} else if (e.getSource() == button6) {
				addDigit(6); return;
		} else if (e.getSource() == button7) {
				addDigit(7); return;
		} else if (e.getSource() == button8) {
				addDigit(8); return;
		} else if (e.getSource() == button9) {
				addDigit(9); return;
		}

		if (e.getSource() == buttonPlus){
			operand1 = Double.parseDouble(textField.getText());
			newNumber = true;
			operator = '+'; return;
		}
		
		if (e.getSource() == buttonMinus){
			operand1 = Double.parseDouble(textField.getText());
			newNumber = true;
			operator = '-'; return;
		}
		
		if (e.getSource() == buttonMultiply){
			operand1 = Double.parseDouble(textField.getText());
			newNumber = true;
			operator = '*'; return;
		}
		
		if (e.getSource() == buttonDivide){
			operand1 = Double.parseDouble(textField.getText());
			newNumber = true;
			operator = '/'; return;
		}
		
		if (e.getSource() == buttonEquals) {
			operand2 = Double.parseDouble(textField.getText());
			switch (operator) {
				case '/': res = operand1 / operand2; break;
				case '*': res = operand1 * operand2; break;
				case '-': res = operand1 - operand2; break;
				case '+': res = operand1 + operand2; break;
			}
			display(""+res);
			newNumber = true;
			return;
		}
		
		if (e.getSource() == buttonC || e.getSource() == buttonCE) {
			display("0.");
			operand1 = null;
			operand2 = null;
			operator = '~';
		}
	}
}