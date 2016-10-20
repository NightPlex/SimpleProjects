import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class MainWindow {

	private JFrame frame;
	private JTextField userUsername;
	private JPasswordField userPassword;

	/**
	 * Launch the application.
	 */
	public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblPassword.setBounds(74, 63, 69, 22);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Bell MT", Font.BOLD, 13));
		lblUsername.setBounds(74, 38, 69, 14);
		frame.getContentPane().add(lblUsername);
		
		userUsername = new JTextField();
		userUsername.setBounds(141, 35, 86, 20);
		frame.getContentPane().add(userUsername);
		userUsername.setColumns(10);
		
		userPassword = new JPasswordField();
		userPassword.setBounds(141, 64, 86, 20);
		frame.getContentPane().add(userPassword);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				BankDatabase database = new BankDatabase();
				
				String username = userUsername.getText();
				
				if (database.getUsername(username) != null) {
					
					if (database.getPassword(username).equals(userPassword.getText())) {
						BankAccountWindow bWindow = new BankAccountWindow(username);
						frame.dispose();
						bWindow.run();
						
						
					} else {
						
						System.out.println(database.getPassword(username));
						
						JOptionPane.showMessageDialog(null, "Wrong password");
						
					}
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Wrong username");
					
				}
				
			}
		});
		loginButton.setBounds(74, 89, 76, 23);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				RegisterWindow rWindow = new RegisterWindow();
				
				rWindow.run();
				
				frame.setVisible(false);
				
			}
		});
		registerButton.setBounds(151, 89, 76, 23);
		frame.getContentPane().add(registerButton);
		
	}
}
