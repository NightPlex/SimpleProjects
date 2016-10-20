import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextPane;

public class Main {

	private JFrame frame;
	private double choice1, choice2, sum;
	private String calcChoice; // This is for either - + * /

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 548, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSimpleCalculator = new JLabel("              Simple Calculator");
		lblSimpleCalculator.setFont(new Font("Snap ITC", Font.BOLD, 21));
		lblSimpleCalculator.setBounds(-18, 11, 422, 56);
		frame.getContentPane().add(lblSimpleCalculator);
		
		JTextPane answerText = new JTextPane();
		answerText.setBounds(169, 173, 253, 29);
		frame.getContentPane().add(answerText);

		JButton button1 = new JButton("1");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "1");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}

			}
		});
		button1.setBounds(90, 374, 54, 47);
		frame.getContentPane().add(button1);

		JButton button2 = new JButton("2");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "2");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
			}
		});
		button2.setBounds(145, 374, 54, 47);
		frame.getContentPane().add(button2);

		JButton button3 = new JButton("3");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "3");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
			}
		});
		button3.setBounds(201, 374, 54, 47);
		frame.getContentPane().add(button3);

		JButton button4 = new JButton("4");
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "4");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
				
			}
		});
		button4.setBounds(201, 327, 54, 47);
		frame.getContentPane().add(button4);

		JButton button5 = new JButton("5");
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "5");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
			}
		});
		button5.setBounds(145, 327, 54, 47);
		frame.getContentPane().add(button5);

		JButton button6 = new JButton("6");
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "6");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
				
			}
		});
		button6.setBounds(90, 327, 54, 47);
		frame.getContentPane().add(button6);

		JButton button7 = new JButton("7");
		button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "7");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
			}
		});
		button7.setBounds(90, 280, 54, 47);
		frame.getContentPane().add(button7);

		JButton button8 = new JButton("8");
		button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "8");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
				
			}
		});
		button8.setBounds(145, 280, 54, 47);
		frame.getContentPane().add(button8);

		JButton button9 = new JButton("9");
		button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (answerText.getText().length() + 1 < 15 ) {
					answerText.setText(answerText.getText() + "9");
				} else {
					
					JOptionPane.showMessageDialog(null, "No more than 14 numbers");
					
				}
				
			}
		});
		button9.setBounds(201, 280, 54, 47);
		frame.getContentPane().add(button9);

		JButton buttonPlus = new JButton("+");
		buttonPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				choice1 = Double.parseDouble(answerText.getText());
				calcChoice = "+";
				answerText.setText("");
				
			}
		});
		buttonPlus.setBounds(256, 374, 54, 47);
		frame.getContentPane().add(buttonPlus);

		JButton buttonMinus = new JButton("-");
		buttonMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				choice1 = Double.parseDouble(answerText.getText());
				calcChoice = "-";
				answerText.setText("");
				
			}
		});
		buttonMinus.setBounds(256, 327, 54, 47);
		frame.getContentPane().add(buttonMinus);

		JButton buttonMultiply = new JButton("*");
		buttonMultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				choice1 = Double.parseDouble(answerText.getText());
				calcChoice = "*";
				answerText.setText("");
				
			}
		});
		buttonMultiply.setBounds(256, 280, 54, 47);
		frame.getContentPane().add(buttonMultiply);

		JButton buttonDivide = new JButton("/");
		buttonDivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				choice1 = Double.parseDouble(answerText.getText());
				calcChoice = "/";
				answerText.setText("");
				
			}
		});
		buttonDivide.setBounds(256, 228, 54, 47);
		frame.getContentPane().add(buttonDivide);

		JButton buttonClear = new JButton("C");
		buttonClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				answerText.setText("");
				
			}
		});
		buttonClear.setBounds(201, 228, 54, 47);
		frame.getContentPane().add(buttonClear);

		JButton buttonPercentage = new JButton("%");
		buttonPercentage.setBounds(145, 228, 54, 47);
		frame.getContentPane().add(buttonPercentage);

		JButton buttonExit = new JButton("Q");
		buttonExit.setBounds(90, 228, 54, 47);
		frame.getContentPane().add(buttonExit);

		JLabel lblAnwser = new JLabel("Answer");
		lblAnwser.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAnwser.setBounds(90, 156, 148, 61);
		frame.getContentPane().add(lblAnwser);

		JButton buttonEquals = new JButton("=");
		buttonEquals.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				choice2 = Double.parseDouble(answerText.getText());
				
				if (calcChoice.equals("+")) {
					
					sum = choice1 + choice2;
					
				} else if (calcChoice.equals("-")) {
					
					sum = choice1 - choice2;
					
				} else if (calcChoice.equals("*")) {
					
					sum = choice1 * choice2;
					
				} else if (calcChoice.equals("/")) {
					
					sum = choice1 / choice2;
					
				}
				
				String answer = Double.toString(sum);
				
				answerText.setText(answer);
				
			}
		});
		buttonEquals.setBounds(315, 228, 89, 193);
		frame.getContentPane().add(buttonEquals);
		
		
		
		
		
		
	}

}
