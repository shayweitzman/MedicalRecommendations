package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import program.LogIn;

public class Log_InFrame implements ActionListener {
	private JFrame welcomeFrame;
	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JTextField txtId;

	public Log_InFrame(JFrame welcomeFrame) {
		this.welcomeFrame = welcomeFrame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		welcomeFrame.setVisible(false);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Login");
		ImageIcon img = new ImageIcon(Welcome.currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1070, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon(
				Welcome.currentRelativePath.toAbsolutePath().toString() + "//source//images//login.png");
		JLabel backgroundLabel = new JLabel(image);
		backgroundLabel.setBounds(0, -10, 1070, 543);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUserName.setBounds(647, 237, 287, 35);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		txtUserName.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtUserName.getText().length() >= 8 ) // limit to 8 characters
	                e.consume();
	        }
	    });
		
		txtPassword = new JPasswordField(10);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtPassword.getText().length() >= 10 ) // limit to 10 characters
	                e.consume();
	        }
	    });
		txtPassword.setBounds(647, 290, 287, 35);
		frame.getContentPane().add(txtPassword);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtId.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (txtId.getText().length() >= 9 ) // limit to 9 characters
	                e.consume();
	        }
	    });
		txtId.setBounds(647, 343, 287, 35);
		frame.getContentPane().add(txtId);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				welcomeFrame.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backButton.setBounds(633, 385, 179, 60);
		backButton.setBackground(new Color(64,166,234));
		backButton.setForeground(Color.white);
		frame.getContentPane().add(backButton);
		
		JButton logInButton = new JButton("Login");
		logInButton.addActionListener((ActionListener)new LogIn(frame, txtUserName, txtPassword, txtId));
		logInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		logInButton.setBounds(822, 385, 179, 60);
		logInButton.setBackground(new Color(64,166,234));
		logInButton.setForeground(Color.white);
		logInButton.setMnemonic(KeyEvent.VK_ENTER);
		
		frame.getContentPane().add(logInButton);
		
		
		frame.getContentPane().add(backgroundLabel);

	}

}
