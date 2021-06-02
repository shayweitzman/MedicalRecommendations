package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import program.SignUp;

import javax.swing.JButton;

public class SignUpFrame implements ActionListener {

	private JFrame welcomeFrame;
	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtCPassword;
	private JTextField txtPassword;
	private JTextField txtId;

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public SignUpFrame(JFrame welcomeFrame) {
		this.welcomeFrame = welcomeFrame;
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		welcomeFrame.setVisible(false);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Sign Up");
		ImageIcon img = new ImageIcon(
				Welcome.currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1070, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		ImageIcon image = new ImageIcon(
				Welcome.currentRelativePath.toAbsolutePath().toString() + "//source//images//Sign_Up.png");
		JLabel backgroundLabel = new JLabel(image);
		backgroundLabel.setBounds(0, -10, 1070, 543);

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtUserName.getText().length() >= 8) // limit to 8 characters
					e.consume();
			}
		});
		txtUserName.setBounds(650, 215, 263, 35);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPassword.getText().length() >= 10) // limit to 10 characters
					e.consume();
			}
		});
		txtPassword.setBounds(650, 268, 263, 35);
		frame.getContentPane().add(txtPassword);

		txtCPassword = new JTextField();
		txtCPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtCPassword.setBounds(650, 319, 263, 35);
		frame.getContentPane().add(txtCPassword);
		txtCPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCPassword.getText().length() >= 10) // limit to 10 characters
					e.consume();
			}
		});

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtId.getText().length() >= 9) // limit to 9 characters
					e.consume();
			}
		});
		txtId.setBounds(650, 372, 263, 35);
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
		backButton.setBounds(657, 417, 149, 58);
		frame.getContentPane().add(backButton);
		backButton.setBackground(new Color(64, 166, 234));
		backButton.setForeground(Color.white);
		frame.getContentPane().add(backButton);

		JButton SignUpButton = new JButton("Sign up");
		SignUpButton
				.addActionListener((ActionListener) new SignUp(frame, txtUserName, txtPassword, txtId, txtCPassword));
		SignUpButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SignUpButton.setBounds(834, 417, 149, 58);
		SignUpButton.setBackground(new Color(64, 166, 234));
		SignUpButton.setForeground(Color.white);
		frame.getContentPane().add(SignUpButton);
		frame.getContentPane().add(backgroundLabel);
	}
}
