import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField username;
	private JTextField password;
	private SqlConnection sql = new SqlConnection();

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					RegisterWindow frame = new RegisterWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public RegisterWindow() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(34, 27, 64, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setBounds(34, 64, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(34, 97, 64, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 133, 64, 14);
		contentPane.add(lblPassword);
		
		firstName = new JTextField();
		firstName.setBounds(132, 24, 119, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(132, 61, 119, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		username = new JTextField();
		username.setBounds(132, 94, 119, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(132, 130, 119, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				if (firstName.getText().isEmpty() || lastName.getText().isEmpty() 
						|| username.getText().isEmpty() || password.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "You must fill all fields");
					
				} else if(firstName.getText().length() < 4) {
					JOptionPane.showMessageDialog(null, "First names are more than 4 letters");
				} else if(lastName.getText().length() < 4) {
					JOptionPane.showMessageDialog(null, "Last names are more than 4 letters");
				} else if(username.getText().length() < 8) {
					JOptionPane.showMessageDialog(null, "Username must be at least 8 characters long");
				} else if(password.getText().length() < 8) {
					JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
				}else {
				
				boolean userTrue  = sql.addUser(firstName.getText(), lastName.getText(), username.getText(), password.getText());
				System.out.println(userTrue);
				
				if (userTrue == false) {
					
					JOptionPane.showMessageDialog(null, "The user alrady exists");
					
				} else if (userTrue == true) {

					
					JOptionPane.showMessageDialog(null, "Successfully registered");
					setVisible(false);
					dispose();
					MainWindow main = new MainWindow();
					main.run();
					
					
				}
				
				}
				
			}
		});
		registerButton.setBounds(56, 212, 304, 23);
		contentPane.add(registerButton);
	}
}
