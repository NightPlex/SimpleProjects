import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankAccountWindow extends JFrame {

	private JPanel contentPane;
	private String username;
	private JTextField userToSend;
	private JTextField amountToSend;
	private SqlConnection sql = new SqlConnection();

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					BankAccountWindow frame = new BankAccountWindow(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public BankAccountWindow(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserInformation = new JLabel("User information:");
		lblUserInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserInformation.setBounds(36, 11, 137, 14);
		contentPane.add(lblUserInformation);
		
		JLabel firstNameLabel = new JLabel("Name: " + sql.getData("firstName", username));
		firstNameLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		firstNameLabel.setBounds(64, 36, 225, 26);
		contentPane.add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last name: " + sql.getData("lastName", username));
		lastNameLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lastNameLabel.setBounds(64, 73, 225, 24);
		contentPane.add(lastNameLabel);
		
		JLabel usernameLabel = new JLabel("username: " + sql.getData("username", username));
		usernameLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		usernameLabel.setBounds(64, 108, 225, 37);
		contentPane.add(usernameLabel);
		
		JLabel accountNumberLabel = new JLabel("Account number: " + sql.getData("accountNumber", username));
		accountNumberLabel.setFont(new Font("Stencil", Font.BOLD, 17));
		accountNumberLabel.setBounds(299, 48, 305, 24);
		contentPane.add(accountNumberLabel);
		
		JLabel creditLabel = new JLabel("Credits: " + sql.getData("credits", username));
		creditLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		creditLabel.setBounds(36, 228, 255, 48);
		contentPane.add(creditLabel);
		
		JLabel lblSendTo = new JLabel("Send to (username):  ");
		lblSendTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSendTo.setBounds(36, 287, 177, 43);
		contentPane.add(lblSendTo);
		
		userToSend = new JTextField();
		userToSend.setBounds(198, 287, 184, 35);
		contentPane.add(userToSend);
		userToSend.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				if (sql.sendCredit(username, userToSend.getText(), Double.parseDouble(amountToSend.getText()))) {
					
					
					creditLabel.setText(Double.toString(sql.getCredits(username)));	
					JOptionPane.showMessageDialog(null, "Successfully sended");
				
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Not enough credit to send or wrong username");
				}
				
			}
		});
		btnNewButton.setBounds(303, 340, 98, 23);
		contentPane.add(btnNewButton); 
		
		amountToSend = new JTextField();
		amountToSend.setBounds(491, 287, 184, 37);
		contentPane.add(amountToSend);
		amountToSend.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount: ");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmount.setBounds(392, 287, 89, 35);
		contentPane.add(lblAmount);
		
		
	}
}
