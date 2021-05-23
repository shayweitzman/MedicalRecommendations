package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import program.SignUp;

import javax.swing.JButton;

public class Sign_UpFrame implements ActionListener {

	private JFrame welcomeFrame;
	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtCPassword;
	private JTextField txtPassword;
	private JTextField txtId;


	/**
	 * Create the application.
	 */
	public Sign_UpFrame(JFrame welcomeFrame) {
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
		frame.setTitle("Sign Up");
		ImageIcon img = new ImageIcon(Welcome.currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1070, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon(
				Welcome.currentRelativePath.toAbsolutePath().toString() + "//source//images//Sign_Up.png");
		JLabel backgroundLabel = new JLabel(Welcome.resizeIcon(image, 1070, 533));
		backgroundLabel.setBounds(0, -10, 1070, 543);
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				welcomeFrame.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backButton.setBounds(657, 400, 149, 58);
		frame.getContentPane().add(backButton);
		backButton.setBackground(new Color(64, 166, 234));
		backButton.setForeground(Color.white);
		frame.getContentPane().add(backButton);
		
		txtUserName = new JTextField("User Name");
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUserName.setBounds(719, 210, 263, 35);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		txtPassword = new JTextField("Password");
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setColumns(10);
		txtPassword.setBounds(719, 256, 263, 35);
		frame.getContentPane().add(txtPassword);

		txtCPassword = new JTextField("Confirm Password");
		txtCPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtCPassword.setBounds(719, 302, 263, 35);
		frame.getContentPane().add(txtCPassword);
		txtCPassword.setColumns(10);

		txtId = new JTextField("ID");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtId.setColumns(10);
		txtId.setBounds(719, 348, 263, 35);
		frame.getContentPane().add(txtId);
		
		JButton SignUpButton = new JButton("Sign up");
		SignUpButton.addActionListener(
				(ActionListener) new SignUp(frame, txtUserName, txtPassword, txtId, txtCPassword));
		SignUpButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SignUpButton.setBounds(834, 400, 149, 58);
		SignUpButton.setBackground(new Color(64, 166, 234));
		SignUpButton.setForeground(Color.white);
		frame.getContentPane().add(SignUpButton);	
		frame.getContentPane().add(backgroundLabel);
	}
}
