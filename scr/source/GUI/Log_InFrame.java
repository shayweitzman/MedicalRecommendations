package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		JLabel backgroundLabel = new JLabel(Welcome.resizeIcon(image, 1070, 533));
		backgroundLabel.setBounds(0, -10, 1070, 543);
		
		txtUserName = new JTextField("User Name",8);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUserName.setBounds(714, 237, 287, 35);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField(10);
		//txtPassword.setEchoChar((char)0);
		txtPassword.setText("Password");		
		//txtPassword.setText();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setColumns(10);
		txtPassword.setBounds(714, 283, 287, 35);
		frame.getContentPane().add(txtPassword);
		
		txtId = new JTextField("ID");
		//txtId.setText("ID");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtId.setColumns(10);
		txtId.setBounds(714, 329, 287, 35);
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
